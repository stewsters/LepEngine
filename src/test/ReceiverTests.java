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
        assert !semi.pullTrigger(); //cant fire initially

        semi.cock();
        assert !semi.pullTrigger(); // no bullets

        semi.changeMags(tenRound);

        assert !semi.pullTrigger(); // uncocked after test fire

        semi.cock();

        assert semi.pullTrigger(); //1
        assert !semi.pullTrigger(); //must release trigger

        semi.releaseTrigger();
        assert semi.pullTrigger(); //2

        semi.releaseTrigger();
        assert semi.pullTrigger(); //3

        semi.releaseTrigger();
        assert semi.pullTrigger(); //4
        assert !semi.pullTrigger(); // out of bullets

    }


    @Test
    public void testAutomaticReceiver(){
        int maxBullets = 12;

        Magazine tenRound = new Magazine(maxBullets,maxBullets);

        Automatic automatic = new Automatic();
        assert !automatic.pullTrigger(); //cant fire initially

        automatic.cock();
        assert !automatic.pullTrigger(); // no bullets

        automatic.changeMags(tenRound);

        assert !automatic.pullTrigger(); // uncocked after test fire

        automatic.cock();
        for(int i =0; i< maxBullets; i++)
        {
            assert automatic.pullTrigger(); //1
        }
        assert !automatic.pullTrigger(); // out of bullets

    }

    @Test
    public void testRevolverReceiver(){
        Revolver revolver = new Revolver();

        revolver.cock();
        assert !revolver.pullTrigger();

        revolver.reload();

        assert !revolver.pullTrigger(); // not cocked

        revolver.cock();

        assert revolver.pullTrigger();
        assert !revolver.pullTrigger(); //must release trigger

        for(int i = 0; i < 5; i++)
        {
            revolver.releaseTrigger();
            assert revolver.pullTrigger();
        }
        assert !revolver.pullTrigger();

    }


    @Test
    public void testBoltActionReceiver(){
        BoltAction boltAction = new BoltAction();
        assert !boltAction.pullTrigger();

        boltAction.openBolt();
        boltAction.closeBolt();
        assert !boltAction.pullTrigger(); //dry fire

        boltAction.openBolt();
        assert boltAction.insertRound();
        boltAction.closeBolt();
        assert !boltAction.pullTrigger(); //cant fire, trigger not released
        boltAction.releaseTrigger();

        boltAction.openBolt();
        assert boltAction.insertRound();
        boltAction.closeBolt();
        assert boltAction.pullTrigger(); //actual fire
        boltAction.releaseTrigger();

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
            assert boltAction.pullTrigger();
            boltAction.releaseTrigger();
            boltAction.cock();
        }

        assert !boltAction.pullTrigger(); // out of ammo

    }

}
