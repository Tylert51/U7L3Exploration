import java.awt.*;
import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double sum = 0;
        for (MenuItem items : check) {
            sum += items.getPrice();
        }

        return sum;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        if (totalPrices() >= 40) {
            for (MenuItem items : check) {
                if (items.isDailySpecial()) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double origPrice = totalPrices();
        double tip = 0;
        double coupon = 0;

        int entrees = 0;
        for (MenuItem item : check) {
            if (item.isEntree()) {
                entrees++;
            }
        }

        if (entrees >= 6) {
            tip = origPrice * 0.2;
        }

        if (couponApplies()) {
            coupon = origPrice * 0.25;
        }

        return origPrice - coupon + tip;
    }
}