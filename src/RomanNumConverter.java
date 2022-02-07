public class RomanNumConverter {
    private static final char I = 'I';
    private static final char V = 'V';
    private static final char X = 'X';

    public static int convertRomToArab(String romanNumb) {
        char[] romanStrFirst = romanNumb.toCharArray();
        char[] romanStr;
        romanStr = new char[romanStrFirst.length + 1];
        romanStr[0] = '0';
        System.arraycopy(romanStrFirst, 0, romanStr, 1, romanStrFirst.length);
        int onesCount = 0;
        int fivesCount = 0;
        int tensCount = 0;
        int finalArab = 0;
        for (int i = 0; i < romanStr.length; i++) {
            if (romanStr[i] == I && romanStr[romanStr.length - 1] == V) {
                onesCount = 4;
            } else if (romanStr[i] == I && romanStr[romanStr.length - 1] == X) {
                onesCount = 9;
            } else {
                if (romanStr[i] == I) {
                    onesCount++;
                }
                if (romanStr[i] == V && romanStr[i - 1] != I) {
                    fivesCount = 5;
                }
                if (romanStr[i] == X && romanStr[i - 1] != I) {
                    tensCount++;
                }
            }
        }
        finalArab = onesCount + fivesCount + (tensCount * 10);
        return finalArab;
    }

    public static String convertArabToRom(int answer) {
        int romHundredsCount = 0;
        int romTensCount = 0;
        romHundredsCount = answer / 100;
        romTensCount = (answer - romHundredsCount * 100) / 10;
        int romOnesCount = (answer - romHundredsCount * 100 - romTensCount * 10);
        String romHundreds = "";
        String romTens = "";
        String romOnes = "";
        //hundreds
        if (romHundredsCount < 4 && romHundredsCount > 0) {
            romHundreds = "C";
            for (int i = 1; i < romHundredsCount; i++) {
                romHundreds = romHundreds + "C";
            }
        } else if (romHundredsCount >= 5 && romHundredsCount < 9) {
            romHundreds = "D";
            for (int i = 5; i < romHundredsCount; i++) {
                romHundreds = romHundreds + "C";
            }
        } else if (romHundredsCount == 4) {
            romHundreds = "СD";
        } else if (romHundredsCount == 9) {
            romHundreds = "СM";
        }
        // tens
        if (romTensCount < 4 && romTensCount > 0) {
            romTens = "X";
            for (int i = 1; i < romTensCount; i++) {
                romTens = romTens + "X";
            }
        } else if (romTensCount >= 5 && romTensCount < 9) {
            romTens = "L";
            for (int i = 5; i < romTensCount; i++) {
                romTens = romTens + "X";
            }
        } else if (romTensCount == 4) {
            romTens = "XL";
        } else if (romTensCount == 9) {
            romTens = "XC";
        }
        //ones
        if (romOnesCount < 4 && romOnesCount > 0) {
            romOnes = "I";
            for (int i = 1; i < romOnesCount; i++) {
                romOnes = romOnes + "I";
            }
        } else if (romOnesCount >= 5 && romOnesCount < 9) {
            romOnes = "V";
            for (int i = 5; i < romOnesCount; i++) {
                romOnes = romOnes + "I";
            }
        } else if (romOnesCount == 4) {
            romOnes = "IV";
        } else if (romOnesCount == 9) {
            romOnes = "IX";
        }
        return romHundreds  + romTens + romOnes;
    }
}