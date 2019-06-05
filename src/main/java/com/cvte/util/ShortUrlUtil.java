package com.cvte.util;

import com.cvte.common.StaticConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
public class ShortUrlUtil {


    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final Logger log = LoggerFactory.getLogger(ShortUrlUtil.class);

    public static char[][] initShortUrlData() {
        char[][] shortUrlElement = new char[DIGITS.length][StaticConfig.SHORT_URL_LENGTH];
        File file = new File(getShortUrlTxtPath());
        try {
            if (!file.exists()) {
                generateShortUrlData();
            }
            FileReader fileReader = new FileReader(file);
            for (int i = 0; i < shortUrlElement.length; i++) {
                for (int j = 0; j < shortUrlElement[i].length; j++) {
                    shortUrlElement[i][j] = (char) fileReader.read();
                }
            }
            fileReader.close();
        } catch (IOException e) {
            log.error("文件操作异常：" + e.getMessage());
        }
        return shortUrlElement;
    }

    /**
     * @throws IOException 初始化数组数据
     */
    private static void generateShortUrlData(){
        File file = null;
        file = new File(getShortUrlTxtPath());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            char[][] data = new char[DIGITS.length][StaticConfig.SHORT_URL_LENGTH];
            for (int i = 0; i < StaticConfig.SHORT_URL_LENGTH; i++) {
                char[] columnArray = generateRandomColumnArray();
                for (int j = 0; j < DIGITS.length; j++) {
                    data[j][i] = columnArray[j];
                }
            }
            for (int i = 0; i < DIGITS.length; i++) {
                for (int j = 0; j < StaticConfig.SHORT_URL_LENGTH; j++) {
                    System.out.print(data[i][j] + " ");
                    fileWriter.write(data[i][j]);
                }
                System.out.println();
            }
            fileWriter.close();
        } catch (IOException e) {
            log.error("文件操作异常：" + e.getMessage());
        }
    }

    /**
     * @return 将数组的列随机打乱
     */
    private static char[] generateRandomColumnArray() {
        char[] result = new char[DIGITS.length];
        System.arraycopy(DIGITS, 0, result, 0, DIGITS.length);
        Random random = new Random();
        for (int i = 0; i < DIGITS.length; i++) {
            swap(result, i, random.nextInt(DIGITS.length));
        }
        return result;
    }

    private static void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static String getShortUrlTxtPath() {
        return ShortUrlUtil.class.getClassLoader().getResource("").getPath() + "/shortUrl.txt";
    }
}
