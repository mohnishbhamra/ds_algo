package com.blah;

public class StackMisc {
    public static void main(String args[]) {
        String seq = "DDDDDDI";
        String ans = printMinimumNumberFromSeq(seq);
        System.out.println(ans);
    }

    private static String printMinimumNumberFromSeq(String arr) {
        String ans = null;
        //int maxNumberToBeUsed = seq.length()+1;
        //return ans;
        // Initialize current_max (to make sure that
        // we don't use repeated character
        int curr_max = 0;

        // Initialize last_entry (Keeps track for
        // last printed digit)
        int last_entry = 0;

        int j;

        // Iterate over input array
        for (int i = 0; i < arr.length(); i++)
        {
            // Initialize 'noOfNextD' to get count of
            // next D's available
            int noOfNextD = 0;

            switch (arr.charAt(i))
            {
                case 'I':
                    // If letter is 'I'

                    // Calculate number of next consecutive D's
                    // available
                    j = i + 1;
                    while (j < arr.length() && arr.charAt(j) == 'D')
                    {
                        noOfNextD++;
                        j++;
                    }

                    if (i == 0)
                    {
                        curr_max = noOfNextD + 2;

                        // If 'I' is first letter, print incremented
                        // sequence from 1
                        System.out.print(" " + ++last_entry);
                        System.out.print(" " + curr_max);

                        // Set max digit reached
                        last_entry = curr_max;
                    }
                    else
                    {
                        // If not first letter

                        // Get next digit to print
                        curr_max = curr_max + noOfNextD + 1;

                        // Print digit for I
                        last_entry = curr_max;
                        System.out.print(" " + last_entry);
                    }

                    // For all next consecutive 'D' print
                    // decremented sequence
                    for (int k = 0; k < noOfNextD; k++)
                    {
                        System.out.print(" " + --last_entry);
                        i++;
                    }
                    break;

                // If letter is 'D'
                case 'D':
                    if (i == 0)
                    {
                        // If 'D' is first letter in sequence
                        // Find number of Next D's available
                        j = i + 1;
                        while (j < arr.length()&&arr.charAt(j) == 'D')
                        {
                            noOfNextD++;
                            j++;
                        }

                        // Calculate first digit to print based on
                        // number of consecutive D's
                        curr_max = noOfNextD + 2;

                        // Print twice for the first time
                        System.out.print(" " + curr_max + " " + (curr_max - 1));

                        // Store last entry
                        last_entry = curr_max - 1;
                    }
                    else
                    {
                        // If current 'D' is not first letter

                        // Decrement last_entry
                        System.out.print(" " + (last_entry - 1));
                        last_entry--;
                    }
                    break;
            }
        }
        System.out.println();
        return ans;
    }
}
