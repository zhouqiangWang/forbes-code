import java.io.*;
import java.util.*;

class Decrypt {

    static String decrypt(String word) {
        // your code goes here
        char[] arr = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        char first = decryptChar(arr[0]);
        sb.append(first);
        // message = 'z';
        // encrypted messge : 'a' ?
        //

//    a -> z

//      char c  + (z) > z - 26 * m
        //   a to z

        //   char enc = c + z - 26 * m
        //   enc - z


        for (int i = 1; i < word.length(); i++) {
            // arr[i] = arr[i] - arr[i - 1];
            int gap = arr[i] - arr[i-1];
            sb.append(decryptChar((char)gap));
        }


        return sb.toString();
    }

//  Add 1 to the first letter, 
//  and then for every letter from the second one to the last one, 
//  add the value of the previous letter.

    //  a b
    // a => a + 1
    // b =>  b + (a + 1) - 26 * m
    // enc[i] = dec[i] + enc[i -1] - 26*m
    // dec[i] = enc[i] - enc[i - 1]
    //
    static char decryptChar(char c) {
//        System.out.println(c);
        while (c > 'z') {
            c -= 26;
        }
//        System.out.println(c);
        while (c < 'a') {
            c += 26;
        }

        return (char)c;
    }

    public static void main(String[] args) {
        System.out.println(decrypt("abc"));

    }

}


  