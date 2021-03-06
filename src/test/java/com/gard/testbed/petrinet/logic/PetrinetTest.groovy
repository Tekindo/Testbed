package com.gard.testbed.petrinet.logic

import com.gard.testbed.engine.petrinet.Arc
import com.gard.testbed.engine.petrinet.InhibitorArc
import com.gard.testbed.engine.petrinet.Petrinet
import com.gard.testbed.engine.petrinet.Place
import com.gard.testbed.engine.petrinet.Transition

/**
 * Created by Chris on 08/03/2016..
 */
class PetrinetTest extends GroovyTestCase {
    private Petrinet pn;
    private Transition t1;
    private Transition t2;
    private Place p1;
    private Place p2;
    private Place p3;

    public void setUp() {
        pn = new Petrinet("Test");
        t1 = pn.transition("t1");
        p1 = pn.place("p1", 2);
        p2 = pn.place("p2");
        Arc a1 = pn.arc("a1", p1,t1);
        Arc a2 = pn.arc("a2", t1,p2);
        a2.setWeight(2);

        t2 = pn.transition("t2");
        p3 = pn.place("p3");
        Arc a3 = pn.arc("a3", p2, t2);
        Arc a4 = pn.arc("a4", t2, p3);

        InhibitorArc inhibitor = pn.inhibitor("inhibitor", p3, t1);
    }

    void testPetriNet() {
        println(pn)
        assertTrue("TEWET", true);
        assertTrue(p1.hasAtLeastTokens(0));
        assertFalse(p1.maxTokensReached(1));
        assertFalse(p2.hasAtLeastTokens(1));
        assertFalse(p1.maxTokensReached(1));

        assertTrue(t1.canFire());
        assertFalse(t2.canFire());

        t1.fire();        assertEquals(1, p1.getTokens());

        System.out.println(pn);

        assertEquals(2, p2.getTokens());

        assertTrue(t1.canFire());
        assertTrue(t2.canFire());

        t2.fire();
        System.out.println(pn);
        System.out.println(pn);

        assertFalse(t1.canFire());
        assertTrue(t2.canFire());

        t2.fire();
        System.out.println(pn);

        assertFalse(t1.canFire());
        assertFalse(t2.canFire());
    }

    void testgetTransitionsAbleToFire() {
        assertTrue(true)
    }
}
