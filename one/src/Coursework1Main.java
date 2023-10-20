import java.util.Objects;

/**
 * Driver class for the SelfStorageUnit class of Coursework 1
 * in the Software and Programming II module at BBK in 2023/24.
 *
 * @author Carsten Fuhs adapted by Paul Nulty
 */
public class Coursework1Main {

    /* The following is a tiny "home-grown" testing framework.
     * We will see a more advanced framework, JUnit, later in the module.
     */

    /** Index value for the next test. */
    private static int testNo = 1;

    /** Number of passed tests. */
    private static int passes = 0;

    /** Number of failed tests. */
    private static int fails = 0;

    /** Output for successful test. */
    private static final String YEA = "OK    "; //"PASSED";

    /** Output for unsuccessful test. */
    private static final String NAY = "FAILED";

    /**
     * Acceptable distance from expected value for double values,
     * should be slightly above 0.
     */
    private static final double DELTA = 1e-9;

    /**
     * Tests two int values for equality.
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testIntEqual(String description, int expected, int actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected == actual);
    }

    /**
     * Tests two long values for equality.
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testLongEqual(String description, long expected, long actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected == actual);
    }

    /**
     * Tests two double values for equality (up to a small "delta").
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testDoubleEqual(String description, double expected, double actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected - DELTA <= actual && actual <= expected + DELTA);
        // small rounding errors are ok
    }

    /**
     * Tests two Objects for equality. Works for Object and all its subclasses
     * (String, Product, ...).
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testObjectEqual(String description, Object expected, Object actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            Objects.equals(expected, actual));
        // Objects.equals is graceful on null
    }

    /**
     * Helper method for the side effects of the tests for different data types
     * (here already converted to Strings): screen output and increment of
     * static counter variables.
     *
     * @param description  description of the test to be printed
     * @param expected  String representation of the expected value
     * @param actual  String representation of the actual value
     * @param result  true: test has passed; false: test has failed
     */
    private static void sideEffectsForTest(String description, String expected, String actual, boolean result) {
        String output;
        if (result) {
            passes++;
            output = YEA;
        } else {
            fails++;
            output = NAY;
        }
        //System.out.println("Test " + testNo + ": " + description
        //    + ", expected: " + expected + ", actual: " + actual
        //    + " ===> " + output);
        System.out.println(output + " - Test " + testNo + ": " + description
            + ", expected: " + expected + ", actual: " + actual);
        testNo++;
    }

    /* The code to test our SelfStorageUnit in particular starts here. */

    /**
     * Constants for use in the tests.
     */
    private static final Item ITEM1 = new Item("Pen", 35);
    private static final Item ITEM2 = new Item("Face mask", 20); 
    private static final Item ITEM3 = new Item("Kilogramme", 1000);
    private static final Item ITEM4 = new Item("Soda", 400);
    private static final Item ITEM5 = new Item("Water", 395);
    private static final Item ITEM6 = new Item("Lemonade", 400);
    private static final Item ITEM7 = new Item("Kilo", 1000);
    private static final Item ITEM8 = new Item("Book", 120);

    /* Methods to create suitably constructed and modified SelfStorageUnit objects. */

    /**
     * @return an empty SelfStorageUnit
     */
    private static SelfStorageUnit makeEmptyUnit() {
        return new SelfStorageUnit();
    }

    /**
     * @return a SelfStorageUnit to which ITEM1 has been added
     */
    private static SelfStorageUnit makeAddOneItemUnit() {
        SelfStorageUnit k = makeEmptyUnit();
        k.add(ITEM1);
        return k;
    }

    /**
     * @return a SelfStorageUnit to which ITEM8 has been added twice
     */
    private static SelfStorageUnit makeAddTwoItemSameUnit() {
        SelfStorageUnit k = makeEmptyUnit();
        k.add(ITEM8);
        k.add(ITEM8);
        return k;
    }

    /**
     * @return a SelfStorageUnit to which ITEM8, null, ITEM8 have been added
     */
    private static SelfStorageUnit makeAddTwoItemSameAndNullUnit() {
        SelfStorageUnit k = makeEmptyUnit();
        k.add(ITEM8);
        k.add(null);
        k.add(ITEM8);
        return k;
    }

    /**
     * @return a SelfStorageUnit to which ITEM1, null, ITEM2 have been added
     */
    private static SelfStorageUnit makeAddTwoItemAndNullUnit() {
        SelfStorageUnit k = makeEmptyUnit();
        k.add(ITEM1);
        k.add(null);
        k.add(ITEM2);
        return k;
    }

    /**
     * @return a SelfStorageUnit on which addAll was invoked with ITEM1, null, ITEM2
     */
    private static SelfStorageUnit makeAddAllTwoItemAndNullUnit() {
        SelfStorageUnit k = makeEmptyUnit();
        Item[] items = { ITEM1, null, ITEM2 };
        k.addAll(items);
        return k;
    }

    /**
     * @return a SelfStorageUnit constructed with ITEM1, null, ITEM2 in the argument
     *  array
     */
    private static SelfStorageUnit makeConstructorTwoItemAndNullUnit() {
        Item[] items = { ITEM1, null, ITEM2 };
        SelfStorageUnit k = new SelfStorageUnit(items);
        return k;
    }

    /**
     * @return a SelfStorageUnit with both constructor arguments and a call to add()
     */
    private static SelfStorageUnit makeConstructorAddTwoItemAndNullUnit() {
        Item[] items = { ITEM1, null };
        SelfStorageUnit k = new SelfStorageUnit(items);
        k.add(ITEM2);
        return k;
    }

    /**
     * @return a SelfStorageUnit on which reset() was called right before returning
     */
    private static SelfStorageUnit makeResetUnit() {
        Item[] items = { ITEM1, null };
        SelfStorageUnit k = new SelfStorageUnit(items);
        k.add(ITEM2);
        k.empty();
        return k;
    }

    /**
     * @return a SelfStorageUnit on which the keepOnlyItemsWith() mutator has been
     *  called to remove some items
     */
    private static SelfStorageUnit makeKeepUnit() {
        Item[] items = { ITEM3, null, ITEM4, ITEM5, ITEM6, ITEM7, ITEM8, null, null, ITEM8  };
        SelfStorageUnit k = new SelfStorageUnit(items);
        k.add(ITEM2);
        k.keepOnlyItemsWith(400);
        return k;
    }

    /**
     * @return an array with two SelfStorageUnits: the first one has ITEM1, ITEM2,
     *  and the second one has ITEM3
     */
    private static SelfStorageUnit[] makeTwoUnits() {
        return new SelfStorageUnit[] { new SelfStorageUnit(new Item[] { ITEM1, ITEM2 }),
                                new SelfStorageUnit(new Item[] { ITEM3 })};
    }

    /**
     * Main method that drives the tests.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        SelfStorageUnit unit;
        unit = makeEmptyUnit();
        testObjectEqual("toString", "[]", unit.toString());
        unit = makeEmptyUnit();
        testObjectEqual("greatestItem", null, unit.greatestItem());
        unit = makeEmptyUnit();
        testIntEqual("numberOfItems", 0, unit.numberOfItems());
        unit = makeEmptyUnit();
        testIntEqual("makeNewUnitWith", 0, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeEmptyUnit();
        testIntEqual("totalWeightInGrammes", 0, unit.totalWeightInGrammes());
        unit = makeEmptyUnit();
        testDoubleEqual("averageWeightInGrammes", -1.0, unit.averageWeightInGrammes());

        unit = makeAddOneItemUnit();
        testObjectEqual("toString", "[" + ITEM1 + "]", unit.toString());
        unit = makeAddOneItemUnit();
        testObjectEqual("greatestItem", ITEM1, unit.greatestItem());
        unit = makeAddOneItemUnit();
        testIntEqual("numberOfItems", 1, unit.numberOfItems());
        unit = makeAddOneItemUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeAddOneItemUnit();
        testIntEqual("makeNewUnitWith", 0, unit.makeNewUnitWith(10).numberOfItems());
        unit = makeAddOneItemUnit();
        testIntEqual("totalWeightInGrammes", 35, unit.totalWeightInGrammes());
        unit = makeAddOneItemUnit();
        testDoubleEqual("averageWeightInGrammes", 35.0, unit.averageWeightInGrammes());

        unit = makeAddTwoItemSameUnit();
        testObjectEqual("toString", "[" + ITEM8 + ", " + ITEM8 + "]", unit.toString());
        unit = makeAddTwoItemSameUnit();
        testObjectEqual("greatestItem", ITEM8, unit.greatestItem());
        unit = makeAddTwoItemSameUnit();
        testIntEqual("numberOfItems", 2, unit.numberOfItems());
        unit = makeAddTwoItemSameUnit();
        testIntEqual("makeNewUnitWith", 2, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeAddTwoItemSameUnit();
        testIntEqual("makeNewUnitWith", 0, unit.makeNewUnitWith(10).numberOfItems());
        unit = makeAddTwoItemSameUnit();
        testIntEqual("totalWeightInGrammes", 240, unit.totalWeightInGrammes());
        unit = makeAddTwoItemSameUnit();
        testDoubleEqual("averageWeightInGrammes", 120.0, unit.averageWeightInGrammes());

        unit = makeAddTwoItemSameAndNullUnit();
        testObjectEqual("toString", "[" + ITEM8 + ", " + ITEM8 + "]", unit.toString());

        unit = makeAddTwoItemAndNullUnit();
        testObjectEqual("greatestItem", ITEM1, unit.greatestItem());
        unit = makeAddTwoItemAndNullUnit();
        testIntEqual("numberOfItems", 2, unit.numberOfItems());
        unit = makeAddTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 2, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeAddTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(21).numberOfItems());
        unit = makeAddTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(20).numberOfItems());
        unit = makeAddTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 0, unit.makeNewUnitWith(19).numberOfItems());
        unit = makeAddTwoItemAndNullUnit();
        testIntEqual("totalWeightInGrammes", 55, unit.totalWeightInGrammes());
        unit = makeAddTwoItemAndNullUnit();
        testDoubleEqual("averageWeightInGrammes", 27.5, unit.averageWeightInGrammes());

        unit = makeAddAllTwoItemAndNullUnit();
        testObjectEqual("greatestItem", ITEM1, unit.greatestItem());
        unit = makeAddAllTwoItemAndNullUnit();
        testIntEqual("numberOfItems", 2, unit.numberOfItems());
        unit = makeAddAllTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 2, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeAddAllTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(21).numberOfItems());
        unit = makeAddAllTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(20).numberOfItems());
        unit = makeAddAllTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 0, unit.makeNewUnitWith(19).numberOfItems());
        unit = makeAddAllTwoItemAndNullUnit();
        testIntEqual("totalWeightInGrammes", 55, unit.totalWeightInGrammes());
        unit = makeAddAllTwoItemAndNullUnit();
        testDoubleEqual("averageWeightInGrammes", 27.5, unit.averageWeightInGrammes());

        unit = makeConstructorTwoItemAndNullUnit();
        testObjectEqual("greatestItem", ITEM1, unit.greatestItem());
        unit = makeConstructorTwoItemAndNullUnit();
        testIntEqual("numberOfItems", 2, unit.numberOfItems());
        unit = makeConstructorTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 2, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeConstructorTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(21).numberOfItems());
        unit = makeConstructorTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(20).numberOfItems());
        unit = makeConstructorTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 0, unit.makeNewUnitWith(19).numberOfItems());
        unit = makeConstructorTwoItemAndNullUnit();
        testIntEqual("totalWeightInGrammes", 55, unit.totalWeightInGrammes());
        unit = makeConstructorTwoItemAndNullUnit();
        testDoubleEqual("averageWeightInGrammes", 27.5, unit.averageWeightInGrammes());

        unit = makeConstructorAddTwoItemAndNullUnit();
        testObjectEqual("greatestItem", ITEM1, unit.greatestItem());
        unit = makeConstructorAddTwoItemAndNullUnit();
        testIntEqual("numberOfItems", 2, unit.numberOfItems());
        unit = makeConstructorAddTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 2, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeConstructorAddTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(21).numberOfItems());
        unit = makeConstructorAddTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 1, unit.makeNewUnitWith(20).numberOfItems());
        unit = makeConstructorAddTwoItemAndNullUnit();
        testIntEqual("makeNewUnitWith", 0, unit.makeNewUnitWith(19).numberOfItems());
        unit = makeConstructorAddTwoItemAndNullUnit();
        testIntEqual("totalWeightInGrammes", 55, unit.totalWeightInGrammes());
        unit = makeConstructorAddTwoItemAndNullUnit();
        testDoubleEqual("averageWeightInGrammes", 27.5, unit.averageWeightInGrammes());

        unit = makeResetUnit();
        testObjectEqual("toString", "[]", unit.toString());
        unit = makeResetUnit();
        testObjectEqual("greatestItem", null, unit.greatestItem());
        unit = makeResetUnit();
        testIntEqual("numberOfItems", 0, unit.numberOfItems());
        unit = makeResetUnit();
        testIntEqual("makeNewUnitWith", 0, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeResetUnit();
        testIntEqual("totalWeightInGrammes", 0, unit.totalWeightInGrammes());
        unit = makeResetUnit();
        testDoubleEqual("averageWeightInGrammes", -1.0, unit.averageWeightInGrammes());

        unit = makeKeepUnit();
        testIntEqual("greatestItem", 400, unit.greatestItem().getWeightInGrammes());
        unit = makeKeepUnit();
        testIntEqual("numberOfItems", 6, unit.numberOfItems());
        unit = makeKeepUnit();
        testIntEqual("makeNewUnitWith", 3, unit.makeNewUnitWith(120).numberOfItems());
        unit = makeKeepUnit();
        testIntEqual("totalWeightInGrammes", 1455, unit.totalWeightInGrammes());
        unit = makeKeepUnit();
        testDoubleEqual("averageWeightInGrammes", 242.5, unit.averageWeightInGrammes());

        testObjectEqual("heaviestUnit", null, SelfStorageUnit.heaviestUnit(new SelfStorageUnit[0]));

        SelfStorageUnit[] units = makeTwoUnits();
        testIntEqual("heaviestUnit", 1000, SelfStorageUnit.heaviestUnit(units).totalWeightInGrammes());

        System.out.println();
        System.out.println(YEA + ": " + passes);
        System.out.println(NAY + ": " + fails);
    }

    /*

OK     - Test 1: toString, expected: [], actual: []
OK     - Test 2: greatestItem, expected: null, actual: null
OK     - Test 3: numberOfItems, expected: 0, actual: 0
OK     - Test 4: makeNewUnitWith, expected: 0, actual: 0
OK     - Test 5: totalWeightInGrammes, expected: 0, actual: 0
OK     - Test 6: averageWeightInGrammes, expected: -1.0, actual: -1.0
OK     - Test 7: toString, expected: [(Pen, 35g)], actual: [(Pen, 35g)]
OK     - Test 8: greatestItem, expected: (Pen, 35g), actual: (Pen, 35g)
OK     - Test 9: numberOfItems, expected: 1, actual: 1
OK     - Test 10: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 11: makeNewUnitWith, expected: 0, actual: 0
OK     - Test 12: totalWeightInGrammes, expected: 35, actual: 35
OK     - Test 13: averageWeightInGrammes, expected: 35.0, actual: 35.0
OK     - Test 14: toString, expected: [(Book, 120g), (Book, 120g)], actual: [(Book, 120g), (Book, 120g)]
OK     - Test 15: greatestItem, expected: (Book, 120g), actual: (Book, 120g)
OK     - Test 16: numberOfItems, expected: 2, actual: 2
OK     - Test 17: makeNewUnitWith, expected: 2, actual: 2
OK     - Test 18: makeNewUnitWith, expected: 0, actual: 0
OK     - Test 19: totalWeightInGrammes, expected: 240, actual: 240
OK     - Test 20: averageWeightInGrammes, expected: 120.0, actual: 120.0
OK     - Test 21: toString, expected: [(Book, 120g), (Book, 120g)], actual: [(Book, 120g), (Book, 120g)]
OK     - Test 22: greatestItem, expected: (Pen, 35g), actual: (Pen, 35g)
OK     - Test 23: numberOfItems, expected: 2, actual: 2
OK     - Test 24: makeNewUnitWith, expected: 2, actual: 2
OK     - Test 25: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 26: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 27: makeNewUnitWith, expected: 0, actual: 0
OK     - Test 28: totalWeightInGrammes, expected: 55, actual: 55
OK     - Test 29: averageWeightInGrammes, expected: 27.5, actual: 27.5
OK     - Test 30: greatestItem, expected: (Pen, 35g), actual: (Pen, 35g)
OK     - Test 31: numberOfItems, expected: 2, actual: 2
OK     - Test 32: makeNewUnitWith, expected: 2, actual: 2
OK     - Test 33: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 34: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 35: makeNewUnitWith, expected: 0, actual: 0
OK     - Test 36: totalWeightInGrammes, expected: 55, actual: 55
OK     - Test 37: averageWeightInGrammes, expected: 27.5, actual: 27.5
OK     - Test 38: greatestItem, expected: (Pen, 35g), actual: (Pen, 35g)
OK     - Test 39: numberOfItems, expected: 2, actual: 2
OK     - Test 40: makeNewUnitWith, expected: 2, actual: 2
OK     - Test 41: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 42: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 43: makeNewUnitWith, expected: 0, actual: 0
OK     - Test 44: totalWeightInGrammes, expected: 55, actual: 55
OK     - Test 45: averageWeightInGrammes, expected: 27.5, actual: 27.5
OK     - Test 46: greatestItem, expected: (Pen, 35g), actual: (Pen, 35g)
OK     - Test 47: numberOfItems, expected: 2, actual: 2
OK     - Test 48: makeNewUnitWith, expected: 2, actual: 2
OK     - Test 49: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 50: makeNewUnitWith, expected: 1, actual: 1
OK     - Test 51: makeNewUnitWith, expected: 0, actual: 0
OK     - Test 52: totalWeightInGrammes, expected: 55, actual: 55
OK     - Test 53: averageWeightInGrammes, expected: 27.5, actual: 27.5
OK     - Test 54: toString, expected: [], actual: []
OK     - Test 55: greatestItem, expected: null, actual: null
OK     - Test 56: numberOfItems, expected: 0, actual: 0
OK     - Test 57: makeNewUnitWith, expected: 0, actual: 0
OK     - Test 58: totalWeightInGrammes, expected: 0, actual: 0
OK     - Test 59: averageWeightInGrammes, expected: -1.0, actual: -1.0
OK     - Test 60: greatestItem, expected: 400, actual: 400
OK     - Test 61: numberOfItems, expected: 6, actual: 6
OK     - Test 62: makeNewUnitWith, expected: 3, actual: 3
OK     - Test 63: totalWeightInGrammes, expected: 1455, actual: 1455
OK     - Test 64: averageWeightInGrammes, expected: 242.5, actual: 242.5
OK     - Test 65: heaviestUnit, expected: null, actual: null
OK     - Test 66: heaviestUnit, expected: 1000, actual: 1000

OK    : 66
FAILED: 0

     */
}
