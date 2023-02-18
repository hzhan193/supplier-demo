import com.apple.zhan193.pojo.Car;
import com.apple.zhan193.pojo.ServiceFactoryProxy;
import com.apple.zhan193.pojo.Student;

public class Main {
    public static void main(String[] args) {

        //before invoke
        System.out.println("before invoke supplier, instances in repository: " + ServiceFactoryProxy.getSize());
        Student student = ServiceFactoryProxy.createStudentService();
        Car car = ServiceFactoryProxy.createCarService();

        System.out.println(student.getClass().getSimpleName() + ":" + student.hashCode());
        System.out.println(car.getClass().getSimpleName() + ":" + car.hashCode());

        System.out.println("after invoke supplier, instances in repository: " + ServiceFactoryProxy.getSize());
    }
}