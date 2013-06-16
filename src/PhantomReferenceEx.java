import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/16/13
 * Time: 3:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class PhantomReferenceEx  {

    public static void main(String[] args) throws InterruptedException {
    Object object = new Object();
    ReferenceQueue q = new ReferenceQueue();
    PhantomReference pr = new PhantomReference(object, q);

    // Later on another point
    Reference r = q.remove();

// Now, clear up any thing you want
    }

}
