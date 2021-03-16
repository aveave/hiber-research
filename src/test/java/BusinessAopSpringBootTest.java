import com.hiberbabl.config.AppConfig;
import com.hiberbabl.dao.AlbumDao;
import com.hiberbabl.dao.InstrumentDao;
import com.hiberbabl.dao.PersonDao;
import com.hiberbabl.dao.SingerDao;
import com.hiberbabl.entity.Album;
import com.hiberbabl.entity.Instrument;
import com.hiberbabl.entity.Person;
import com.hiberbabl.entity.PersonType;
import com.hiberbabl.entity.Singer;
import com.hiberbabl.service.InstrumentService;
import com.hiberbabl.service.SingerService;
import com.hiberbabl.service.StateBean;
import com.hiberbabl.service.SuperStateBean;
import com.hiberbabl.test.RequestHandler;
import com.hiberbabl.test.RequestManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class BusinessAopSpringBootTest {

  @Autowired
  private SingerDao singerDao;

  @Autowired
  private InstrumentDao instrumentDao;

  @Autowired
  private AlbumDao albumDao;

  @Autowired
  private InstrumentService instrumentService;

  @Autowired
  private SingerService singerService;

  @Autowired
  private StateBean stateBean;

  @Autowired
  private SuperStateBean superStateBean;

  @Autowired
  private RequestManager requestManager;

  @Autowired
  private RequestHandler requestHandler;

  @Autowired
  private PersonDao personDao;

  @Test
  public void testCreateSinger() {

    Singer singer = new Singer("Joni", "Boi");
    singerDao.save(singer);
    System.out.println("123d");
  }

  public void testCreateSingerWithAlbums() {
    Singer singer = new Singer();
//    singer.s
  }

  @Test
  public void testCreateInstrument() {
    Instrument instrument = new Instrument();
    instrument.setInstrumentId("Guita");
    instrument.getSingers().add(
            new Singer("Kekkek", "Knet")
    );
    instrumentDao.saveWrap(instrument);
  }

  @Test
  public void testManyToManyRelationship() {
//    Singer singer = new Singer();
//    singer.setFirstName("Gleb");
//    singer.setLastName("Beb");
//    singer.setBirthDate(new Date(2020, 11, 10));
//    singer
//
//    singerDao.save(singer);

    Singer singer = singerService.findById(2L);
    System.out.println(singer);

//      Instrument instrument = instrumentService.findById("Guitar");
//      instrument.getSingers();

  }

  @Test
  public void testAlbum() {

    Singer singer1 = singerDao.findById(2L);

    Singer singer2 = singerDao.findById(3L);

    Singer singer3 = singerDao.findById(4L);

    Album album = new Album();
    album.setTitle("Title 1");
    album.setVersion(1);
    album.setSinger(singer1);
    album.setReleaseDate(new Date(2020, 10, 10));

    Album album2 = new Album();
    album.setTitle("Title 2");
    album.setVersion(1);
    album.setSinger(singer2);
    album.setReleaseDate(new Date(2020, 11, 1));

    Album album3 = new Album();
    album.setTitle("Title 3");
    album.setVersion(1);
    album.setSinger(singer3);
    album.setReleaseDate(new Date(2020, 11, 9));

    albumDao.save(album);
    albumDao.save(album2);
    albumDao.save(album3);

    List<Album> albums = albumDao.findAll();
    for (Album currentAlbum: albums) {
      System.out.println(currentAlbum);
    }
  }

  @Test
  public void testBean() {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//    StateBean stateBean1 = (StateBean) applicationContext.getBean("stateBean");
//
//    stateBean1.setP(20);
//
//    System.out.println("StateBean 1 value = " + stateBean1.getP());
//
//    StateBean stateBean2 = (StateBean) applicationContext.getBean("stateBean");
//
//    System.out.println("StateBean 2 value = " + stateBean2.getP());

//    System.out.println("SuperStateBean " + superStateBean.getTemp());

    SuperStateBean superStateBean = applicationContext.getBean(SuperStateBean.class);



    System.out.println(superStateBean.getStateBean().getP());

    superStateBean.getStateBean().setP(10000);

    System.out.println(superStateBean.getStateBean().getP());

  }

  @Test
  public void testRequest() {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    RequestManager requestManager = (RequestManager) applicationContext.getBean("requestManager");
    requestManager.handleRequest();
    requestManager.handleRequest();
    requestManager.handleRequest();

  }

  @Test
  public void testEnum() {

    Person person = new Person("Bab", PersonType.DIVORCED);

    personDao.save(person);

  }

}
