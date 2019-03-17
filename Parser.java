import java.io.*;



public class Parser {

    public static void main(String[] args) throws IOException {

        String st;
        String word;
        String keywordStake = " Stake:";
        String keywordWinnings = "winnings:";
        String[] ar;
        float stake = 0;
        float winnings = 0;

        File file = new File("C:\\Users\\adam.evans\\Java\\Game_log.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        /**
         * reading each line of text file, checking if line contains the key
         * word if true splitting line and adding line to array
         */
        while ((st = br.readLine()) != null) {
           
            
            if (st.contains(keywordStake)) {
                ar = st.split(", ");

                /**
                 * Taking the last index of the array as that is where the stake
                 * is held and removing all characters except digits and decimals
                 */
                word = ar[ar.length - 1];
                word = word.replaceAll("[^0-9.]", "");

                /**
                 * Adding total stake
                 */
                stake = stake + Float.parseFloat(word);
            }

            if (st.contains(keywordWinnings)) {
                ar = st.split(", ");
                word = ar[ar.length - 1];

                word = word.replaceAll("[^0-9.]", "");
                winnings = winnings + Float.parseFloat(word);
            }
        }

        System.out.println("Total stake is : " + stake);
        System.out.println("Total Winnings is : " + winnings);
        float RTP = (winnings / stake) * 100;
        System.out.println("Return to player is : " + RTP);
    }
}
