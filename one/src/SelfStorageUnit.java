/**
 * A SelfStorageUnit holds zero or more Items and can provide information about the
 * Items. One can add Items to a SelfStorageUnit during its lifetime, empty the
 * SelfStorageUnit, create a copy which contains Items only up to a certain weight,
 * and make various queries to the SelfStorageUnit. (Thus, the number of Items that
 * will be stored by a SelfStorageUnit object is not yet known when the new object
 * is created, and it may grow and shrink over the lifetime of a SelfStorageUnit
 * object.)
 *
 * @author
 */
public class SelfStorageUnit {

    // TO DO

    /* Constructors */

    /**
     * Constructs a new SelfStorageUnit without any Items.
     */
    public SelfStorageUnit() {
        // TO DO
    }

    /**
     * Constructs a new SelfStorageUnit containing the non-null Items in items.
     * The items array may be modified by the caller afterwards without
     * affecting this SelfStorageUnit, and it will not be modified by this
     * constructor.
     *
     * @param items must not be null; non-null elements are added to the
     *  constructed SelfStorageUnit
     */
    public SelfStorageUnit(Item[] items) {
        // TO DO
    }

    /* Modifiers */

    /**
     * Adds an Item e to this SelfStorageUnit if e is not null; does not modify this
     * SelfStorageUnit otherwise. Returns true if e is not null, false otherwise.
     *
     * @param e an item to be added to this SelfStorageUnit
     * @return true if e is not null, false otherwise
     */
    public boolean add(Item e) {
        // TO DO
        return false;
    }

    /**
     * Adds all non-null Items in items to this SelfStorageUnit.
     *
     * @param items contains the Item objects to be added to
     *  this SelfStorageUnit; must not be null (but may contain null)
     * @return true if at least one element of items is non-null;
     *  false otherwise
     */
    public boolean addAll(Item[] items) {
        // TO DO
        return false;
    }

    /**
     * Empties this SelfStorageUnit to a SelfStorageUnit that contains 0 Items.
     */
    public void empty() {
        // TO DO
    }

    /**
     * Removes certain Items from this SelfStorageUnit. Exactly those Items are kept
     * whose weight in grammes is less than or equal to the specified maximum
     * weight in grammes.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items that are kept
     */
    public void keepOnlyItemsWith(int maxItemWeightInGrammes) {
        // TO DO
    }

    /* Accessors */

    /**
     * Returns the number of non-null Items in this SelfStorageUnit.
     *
     * @return the number of non-null Items in this SelfStorageUnit
     */
    public int numberOfItems() {
        // TO DO
        return 0;
    }

    /**
     * Returns the total weight of the Items in this SelfStorageUnit.
     *
     * @return the total weight of the Items in this SelfStorageUnit.
     */
    public int totalWeightInGrammes() {
        // TO DO
        return 0;
    }

    /**
     * Returns the average weight in grammes of the (non-null) Items
     * in this SelfStorageUnit. In case there is no Item in this SelfStorageUnit,
     * -1.0 is returned.
     *
     * For example, if this SelfStorageUnit has the contents
     *   new Item("clock", 400)
     * and
     *   new Item("textbook", 395),
     * the result is: 397.5
     *
     * @return the average length of the Items in this SelfStorageUnit,
     *  or -1.0 if there is no such Item.
     */
    public double averageWeightInGrammes() {
        // TO DO
        return 0.0;
    }

    /**
     * Returns the greatest Item in this SelfStorageUnit according to the
     * natural ordering of Item given by its compareTo method;
     * null if this SelfStorageUnit does not contain any Item objects
     *
     * @return the greatest Item in this SelfStorageUnit according to the
     *  natural ordering of Item given by its compareTo method;
     *  null if this SelfStorageUnit does not contain any Item objects
     */
    public Item greatestItem() {
        // TO DO
        return null;
    }

    /**
     * Returns a new SelfStorageUnit with exactly those Items of this SelfStorageUnit
     * whose weight is less than or equal to the specified method parameter.
     * Does not modify this SelfStorageUnit.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items in the new SelfStorageUnit
     * @return a new SelfStorageUnit with exactly those Items of this SelfStorageUnit
     *  whose weight is less than or equal to the specified method parameter
     */
    public SelfStorageUnit makeNewUnitWith(int maxItemWeightInGrammes) {
        // TO DO
        return null;
    }

    /**
     * Returns a string representation of this SelfStorageUnit. The string
     * representation consists of a list of the SelfStorageUnit's contents,
     * enclosed in square brackets ("[]"). Adjacent Items are
     * separated by the characters ", " (comma and space). Items are
     * converted to strings as by their toString() method. The
     * representation does not mention any null references.
     *
     * So for
     *
     * Item i1 = new Item("Pen", 15);
     * Item i2 = new Item("Letter", 20);
     * Item i3 = null;
     * Item[] items = { i1, i2, i3, i1 };
     * SelfStorageUnit k = new SelfStorageUnit(items);
     *
     * the call k.toString() will return one of the three following Strings:
     *
     * "[(Pen, 15g), (Pen, 15g), (Letter, 20g)]"
     * "[(Pen, 15g), (Letter, 20g), (Pen, 15g)]"
     * "[(Letter, 20g), (Pen, 15g), (Pen, 15g)]"
     *
     * @return a String representation of this SelfStorageUnit
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // TO DO
        return null;
    }

    /* class methods */

    /**
     * Class method to return a SelfStorageUnit with the highest total weight from an
     * array of SelfStorageUnits. If we have an array with a SelfStorageUnit of 3000 grammes
     * and a SelfStorageUnit with 4000 grammes, the SelfStorageUnit with 4000 grammes is
     * returned.
     *
     * Entries of the array may be null, and your method should work also in
     * the presence of such entries. So if in the above example we had an
     * additional third array entry null, the result would be exactly the same.
     *
     * If there are several SelfStorageUnits with the same weight, it is up to the
     * method implementation to choose one of them as the result (i.e., the
     * choice is implementation-specific, and method users should not rely on
     * any particular behaviour).
     *
     * @param SelfStorageUnits must not be null, but may contain null
     * @return one of the SelfStorageUnits with the highest total weight among all
     *  SelfStorageUnits in the parameter array; null if there is no non-null
     *  reference in SelfStorageUnits
     */
    public static SelfStorageUnit heaviestUnit(SelfStorageUnit[] SelfStorageUnitss) {
        // TO DO
        return null;
    }
}
