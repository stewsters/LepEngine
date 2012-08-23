package test;


import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.receiver.Automatic;
import com.stewsters.weapons.gun.receiver.BoltAction;
import com.stewsters.weapons.gun.receiver.Revolver;
import com.stewsters.weapons.gun.receiver.SemiAutomatic;
import org.junit.Test;

public class ReceiverTests {

    @Test
    public void testSemiAutoReceiver(){

        Magazine tenRound = new Magazine(10,4);

        SemiAutomatic semi = new SemiAutomatic();
        assert !semi.fireRound(); //cant fire initially

        semi.cock();
        assert !semi.fireRound(); // no bullets

        semi.changeMags(tenRound);

        assert !semi.fireRound(); // uncocked after test fire

        semi.cock();

        assert semi.fireRound(); //1
        assert !semi.fireRound(); //must release trigger

        semi.leftRelease();
        assert semi.fireRound(); //2

        semi.leftRelease();
        assert semi.fireRound(); //3

        semi.leftRelease();
        assert semi.fireRound(); //4
        assert !semi.fireRound(); // out of bullets

    }


    @Test
    public void testAutomaticReceiver(){
        int maxBullets = 12;

        Magazine tenRound = new Magazine(maxBullets,maxBullets);

        Automatic automatic = new Automatic();
        assert !automatic.fireRound(); //cant fire initially

        automatic.cock();
        assert !automatic.fireRound(); // no bullets

        automatic.changeMags(tenRound);

        assert !automatic.fireRound(); // uncocked after test fire

        automatic.cock();
        for(int i =0; i< maxBullets; i++)
        {
            assert automatic.fireRound(); //1
        }
        assert !automatic.fireRound(); // out of bullets

    }

    @Test
    public void testRevolverReceiver(){
        Revolver revolver = new Revolver();

        revolver.cock();
        assert !revolver.fireRound();

        revolver.reload();

        assert !revolver.fireRound(); // not cocked

        revolver.cock();

        assert revolver.fireRound();
        assert !revolver.fireRound(); //must release trigger

        for(int i = 0; i < 5; i++)
        {
            revolver.leftRelease();
            assert revolver.fireRound();
        }
        assert !revolver.fireRound();

    }


    @Test
    public void testBoltActionReceiver(){
        BoltAction boltAction = new BoltAction();
        assert !boltAction.fireRound();

        boltAction.openBolt();
        boltAction.closeBolt();
        assert !boltAction.fireRound(); //dry fire

        boltAction.openBolt();
        assert boltAction.insertRound();
        boltAction.closeBolt();
        assert !boltAction.fireRound(); //actual fire
        boltAction.leftRelease();

        boltAction.openBolt();
        assert boltAction.insertRound();
        boltAction.closeBolt();
        assert boltAction.fireRound(); //actual fire
        boltAction.leftRelease();

        //5 in the clip, 1 in the chamber
        boltAction.openBolt();
        assert boltAction.insertRound();
        assert boltAction.insertRound();
        assert boltAction.insertRound();
        assert boltAction.insertRound();
        assert boltAction.insertRound();
        assert boltAction.insertRound();
        boltAction.closeBolt();

        for(int i = 0; i < 6; i++){
            System.out.println(i);
            assert boltAction.fireRound();
            boltAction.leftRelease();
            boltAction.cock();
        }


    }

}
