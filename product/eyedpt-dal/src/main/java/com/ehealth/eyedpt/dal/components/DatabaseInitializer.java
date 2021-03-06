/*
 * Created on 2011-8-9
 */

package com.ehealth.eyedpt.dal.components;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collections;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ehealth.eyedpt.dal.entities.Admin;
import com.ehealth.eyedpt.dal.entities.Booking;
import com.ehealth.eyedpt.dal.entities.BookingRoster;
import com.ehealth.eyedpt.dal.entities.Department;
import com.ehealth.eyedpt.dal.entities.Doctor;
import com.ehealth.eyedpt.dal.entities.DoctorBlob;
import com.ehealth.eyedpt.dal.entities.DoctorCap;
import com.ehealth.eyedpt.dal.entities.Hospital;
import com.ehealth.eyedpt.dal.entities.Patient;
import com.ehealth.eyedpt.dal.entities.User;
import com.ehealth.eyedpt.dal.entities.enums.BookingStatus;
import com.ehealth.eyedpt.dal.entities.enums.DoctorAdminTitle;
import com.ehealth.eyedpt.dal.entities.enums.DoctorTitle;
import com.ehealth.eyedpt.dal.entities.enums.ExpertRank;
import com.ehealth.eyedpt.dal.entities.enums.Gender;
import com.ehealth.eyedpt.dal.entities.enums.NotifyType;
import com.ehealth.eyedpt.dal.entities.enums.RegistryType;
import com.ehealth.eyedpt.dal.entities.enums.SupervisorType;
import com.ehealth.eyedpt.dal.entities.enums.TimeSlot;
import com.ehealth.eyedpt.dal.entities.enums.UserGroup;
import com.ehealth.eyedpt.dal.entities.enums.Weekday;
import com.ehealth.eyedpt.dal.repositories.AdminDao;
import com.ehealth.eyedpt.dal.repositories.BookingDao;
import com.ehealth.eyedpt.dal.repositories.BookingRosterDao;
import com.ehealth.eyedpt.dal.repositories.DepartmentDao;
import com.ehealth.eyedpt.dal.repositories.DoctorBlobDao;
import com.ehealth.eyedpt.dal.repositories.DoctorCapDao;
import com.ehealth.eyedpt.dal.repositories.DoctorDao;
import com.ehealth.eyedpt.dal.repositories.HospitalDao;
import com.ehealth.eyedpt.dal.repositories.PatientDao;
import com.ehealth.eyedpt.dal.repositories.UserDao;

/**
 * Sets up database for dev/test use.
 * 
 * @author emac
 */
@Component
public class DatabaseInitializer
        implements ApplicationListener<ContextRefreshedEvent>
{

    private static Logger      logger         = Logger.getLogger(DatabaseInitializer.class);

    public static final String TEST_PATIENT   = "tp";
    public static final String TEST_ADMIN     = "ta";
    public static final String TEST_DOCTOR    = "td";

    public static final String HOSTPITAL_NO1  = "上海市第一人民医院";
    public static final String DEPARTMENT_EYE = "眼科";

    @Autowired
    private UserDao            userDao;

    @Autowired
    private AdminDao           adminDao;

    @Autowired
    private PatientDao         patientDao;

    @Autowired
    private DoctorDao          doctorDao;

    @Autowired
    private DoctorBlobDao      doctorBlobDao;

    @Autowired
    private HospitalDao        hospitalDao;

    @Autowired
    private DepartmentDao      departmentDao;

    @Autowired
    private DoctorCapDao       doctorCapDao;

    @Autowired
    private BookingRosterDao   bookingRosterDao;

    @Autowired
    private BookingDao         bookingDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        try
        {
            initDB();

            logger.info("Database initialized!");
        }
        catch (IOException e)
        {
            logger.error("Error occurs when initializing database!", e);
        }
    }

    private void initDB()
            throws IOException
    {
        if ( this.adminDao.findAll().size() > 0 )
        {
            return;
        }

        createRootAdmin();
        createTestPatient();
        createTestAdmin();
        createTestDoctor();
        createSuperDoctor();

        initBookings();
    }

    private void createRootAdmin()
    {
        // user
        User user = new User();
        user.setName("root");
        user.setPassword("r00t");
        user.setUsergroup(UserGroup.ADMIN);
        user.setRoleset(new byte[]
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        // hospital
        Hospital firstHospital = new Hospital();
        firstHospital.setName(HOSTPITAL_NO1);
        firstHospital.setProvince("上海");
        firstHospital.setCity("上海");
        firstHospital.setAddress("虹口区海宁路100号(近吴淞路)");
        firstHospital.setPostcode("200080");
        firstHospital.setTelephone("021-63240090");

        // department
        Department eyeDep = new Department();
        eyeDep.setHospital(firstHospital);
        eyeDep.setName(DEPARTMENT_EYE);
        eyeDep.setFamous(true);

        // admin
        Admin root = new Admin();
        root.setUser(user);
        root.setRoot(true);
        root.setEmail("root@seeeye.org");
        root.setHospital(firstHospital);
        root.setDepartments(Collections.singleton(eyeDep));

        this.adminDao.create(root);

        logger.info("Super user created!");
    }

    private void createTestAdmin()
    {
        // user
        User user = new User();
        user.setName(TEST_ADMIN);
        user.setPassword(TEST_ADMIN);
        user.setUsergroup(UserGroup.ADMIN);
        user.setRoleset(new byte[]
        { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        // admin
        Admin ta = new Admin();
        ta.setUser(user);
        ta.setRoot(false);
        ta.setEmail("ta@seeeye.org");

        Hospital hospital = this.hospitalDao.findByName(HOSTPITAL_NO1);
        ta.setHospital(hospital);
        this.adminDao.create(ta);

        Department department = this.departmentDao.findByHospitalAndName(hospital, DEPARTMENT_EYE);
        ta.setDepartments(Collections.singleton(department));
        this.adminDao.update(ta);

        logger.info("Test admin created!");
    }

    private void createTestPatient()
    {
        // user
        User user = new User();
        user.setName(TEST_PATIENT);
        user.setPassword(TEST_PATIENT);
        user.setUsergroup(UserGroup.PATIENT);
        user.setRoleset(new byte[]
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        // patient
        Patient tp = new Patient();
        tp.setUser(user);
        tp.setRealname("test");
        tp.setGender(Gender.M);
        tp.setAge(99);
        tp.setProvince("test");
        tp.setCity("test");
        tp.setRegistrytype(RegistryType.ID);
        tp.setRegistryno("test");
        tp.setEmail("tp@seeeye.org");
        tp.setCellphone("11111111111");

        this.patientDao.create(tp);

        logger.info("Test patient created!");
    }

    private void createTestDoctor()
    {
        // user
        User user = new User();
        user.setName(TEST_DOCTOR);
        user.setPassword(TEST_DOCTOR);
        user.setUsergroup(UserGroup.DOCTOR);
        user.setRoleset(new byte[]
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        // doctor
        Doctor td = new Doctor();
        td.setUser(user);
        td.setRealname("test");
        td.setGender(Gender.F);
        td.setAge(20);
        td.setEmail("tp@seeeye.org");
        td.setCellphone("11111111111");
        td.setAddress("test");
        td.setEmployeeid("1111");
        td.setTitle(DoctorTitle.INTERN);
        td.setAdmintitle(DoctorAdminTitle.SXYSDJ);
        td.setExpertrank(ExpertRank.GENERAL);
        td.setSpecialities("test");
        td.setSupervisortype1(SupervisorType.NA);
        td.setSupervisortype2(SupervisorType.NA);
        td.setSupervisortype3(SupervisorType.NA);

        Hospital hospital = this.hospitalDao.findByName(HOSTPITAL_NO1);
        td.setHospital(hospital);
        Department department = this.departmentDao.findByHospitalAndName(hospital, DEPARTMENT_EYE);
        td.setDepartment(department);
        this.doctorDao.create(td);

        // doctor blob
        DoctorBlob blob = new DoctorBlob();
        blob.setDoctor(td);
        blob.setDescription("test");
        this.doctorBlobDao.create(blob);

        // doctor cap
        DoctorCap cap = new DoctorCap();
        cap.setDoctor(td);
        cap.setAcceptbookings(true);
        cap.setBookingprice(999.9f);
        this.doctorCapDao.create(cap);

        logger.info("Test doctor created!");
    }

    private void createSuperDoctor()
            throws IOException
    {
        // user
        User user = new User();
        user.setName("emac");
        user.setPassword("came");
        user.setUsergroup(UserGroup.DOCTOR);
        user.setRoleset(new byte[]
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        // doctor
        Doctor td = new Doctor();
        td.setUser(user);
        td.setRealname("super");
        td.setGender(Gender.M);
        td.setAge(30);
        td.setEmail("emac.ehealth@ttdong.com.cn");
        td.setCellphone("99999999999");
        td.setAddress("super");
        td.setEmployeeid("9528");
        td.setTitle(DoctorTitle.PROFESSOR);
        td.setAdmintitle(DoctorAdminTitle.KSZR);
        td.setExpertrank(ExpertRank.VIP);
        td.setSpecialities("super");
        td.setSupervisortype1(SupervisorType.DOCTOR);
        td.setSupervisorcollege1("super");
        td.setSupervisortype2(SupervisorType.MASTER);
        td.setSupervisorcollege2("super");
        td.setSupervisortype3(SupervisorType.NA);

        Hospital hospital = this.hospitalDao.findByName(HOSTPITAL_NO1);
        td.setHospital(hospital);
        Department department = this.departmentDao.findByHospitalAndName(hospital, DEPARTMENT_EYE);
        td.setDepartment(department);
        this.doctorDao.create(td);

        // doctor blob
        DoctorBlob blob = new DoctorBlob();
        blob.setDoctor(td);
        InputStream is = getClass().getResourceAsStream("emacoo.jpg");
        blob.setPhoto(IOUtils.toByteArray(is));
        blob.setDescription("super");
        this.doctorBlobDao.create(blob);

        // doctor cap
        DoctorCap cap = new DoctorCap();
        cap.setDoctor(td);
        this.doctorCapDao.create(cap);

        logger.info("Super doctor created!");
    }

    private void initBookings()
    {
        // booking roster
        Doctor td = this.doctorDao.findByUser(this.userDao.findByName("td"));
        BookingRoster roster = new BookingRoster();
        roster.setDoctor(td);
        roster.setDayofweek(Weekday.FRI);
        roster.setTimeslot(TimeSlot.PM);
        roster.setCapability(5);
        this.bookingRosterDao.create(roster);

        // booking
        Patient tp = this.patientDao.findByUser(this.userDao.findByName("tp"));
        Booking b = new Booking();
        b.setBookingid(1109090001);
        b.setPatient(tp);
        b.setDoctor(td);
        b.setPostdate(new Timestamp(System.currentTimeMillis()));
        b.setBookingdate(new Date(System.currentTimeMillis()));
        b.setTimeslot(TimeSlot.AM);
        b.setStatus(BookingStatus.ACCEPTED);
        b.setNotifytype(NotifyType.EMAIL);
        b.setNotified(false);
        this.bookingDao.create(b);

        logger.info("Bookings initialized!");
    }

}
