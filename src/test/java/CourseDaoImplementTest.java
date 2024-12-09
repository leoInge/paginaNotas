import com.example.proyectoprograweb.logic.Activity;
import com.example.proyectoprograweb.logic.Course;
import com.example.proyectoprograweb.persistence.ActivityDaoFactory;
import com.example.proyectoprograweb.persistence.CourseDaoFactory;
import com.example.proyectoprograweb.persistence.InterfaceDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseDaoImplementTest {
    private CourseDaoFactory factory = new CourseDaoFactory();

    @Test
    void getAll() {/*
        InterfaceDao curso = factory.createCourseDao();
        List<Course> cursos = curso.getAll();
        assertNotNull( cursos );
        assertEquals(0,cursos.size());
       for (int i=0;i<cursos.size();i++){
           System.out.println(cursos.get(i).getName());
       }*/
    }

    @Test
    void findById() {/*
        InterfaceDao interfaceDao = factory.createRoomDao();
        Room room = (Room) interfaceDao.findById("S7");
        assertNotNull(room);
        assertEquals("Sala de Informatica 7",room.getDescription());
        assertEquals(20,room.getCapacity());
        assertNull( interfaceDao.findById("No Eziste"));*/
    }

    @Test
    void addRoom() {/*
        InterfaceDao interfaceDao = factory.createCourseDao();
        // assertEquals(1, interfaceDao.add( new Course("2","Fisica","30")));
        //assertEquals(1, interfaceDao.add( new Course("3","otra","30")));
        //  assertEquals(1, interfaceDao.add( new Course("4","si","30")));
        interfaceDao.delete(interfaceDao.findById("2"));
           interfaceDao.delete(interfaceDao.findById("3"));
          interfaceDao.delete(interfaceDao.findById("4"));
        interfaceDao.delete(interfaceDao.findById("50"));
        interfaceDao.delete(interfaceDao.findById("69"));*/
    }

    @Test
    void update() {//pereeee
    }

    @Test
    void delete() {
    }
    @Test
    void calcularNotas() {
     /*   String id="101";
        InterfaceDao inter = factory.createCourseDao();
        System.out.println("total:" +inter.CalcularNota(id));
*/
    }
}
