package com.blah;

class Solution2 {
    public boolean checkStraightLine(int[][] coordinates) {
        int length=coordinates.length;
        System.out.println("the length is "+length);
        if (length == 2) {
            return true;
        }

        int index=0;
        float x1 = coordinates[index+0][0];
        float x2 = coordinates[index+1][0];

        float y1 = coordinates[index+0][1];
        float y2 = coordinates[index+1][1];
        System.out.println("y2="+y2+" y1="+y1+" x2="+x2+" x1="+x1);
        float prevM = (y2 - y1) / (x2 - x1);
        System.out.println("slope"+index+"  "+prevM);
        float newM;
        do {
            index++;
            x1 = coordinates[index+0][0];
            x2 = coordinates[index+1][0];


            y1 = coordinates[index+0][1];
            y2 = coordinates[index+1][1];


            newM = (y2 - y1) / (x2 - x1);
            System.out.println("y2="+y2+" y1="+y1+" x2="+x2+" x=1"+x1);
            System.out.println("slope"+index+"  "+newM);
            if (newM != prevM) {
                return false;
            }
            prevM = newM;
        }while (index!=length-2);

        return true;
    }
}