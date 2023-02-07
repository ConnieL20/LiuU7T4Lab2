import java.util.ArrayList;

public class Delimiters
{
    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close)
    {
        openDel = open;
        closeDel = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens)
    {
        ArrayList<String> delimiters = new ArrayList<>();
        for (String str : tokens){
            if (this.openDel.equals(str) || this.closeDel.equals(str)){
                delimiters.add(str);
            }
        }
        return delimiters;
    }

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters)
    {
        int openCount = 0;
        int closeCount = 0;

        if (delimiters.size() < 2){
            return false;
        } else if (!delimiters.get(0).equals(this.openDel)){
            return false;
        } else if (!delimiters.get(delimiters.size() - 1).equals(this.closeDel)){
            return false;
        }

        for (String str : delimiters){
            if (str.equals(this.openDel)){
                openCount++;
            } else if (str.equals(this.closeDel)){
                closeCount++;
            }
        }

        if (openCount != closeCount){
            return false;
        } else {
            return true;
        }
    }
}