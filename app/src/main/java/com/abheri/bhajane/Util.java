package com.abheri.bhajane;

import android.content.Context;
import android.graphics.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Util {

    public static BhajaneData[] makeContent(Context context){
        int image = R.drawable.om_transparent_bg;
        int color = Color.parseColor("#ffffff");
        BhajaneData[] myListData;

        String[] ch_names = context.getResources().getStringArray(R.array.contents);
        myListData =
            new BhajaneData[]
                {
                    new BhajaneData(ch_names[0].toString(),readPageFromAssetFile("kannada/page0.txt", context), image,color),
                    new BhajaneData(ch_names[1].toString(),readPageFromAssetFile("kannada/page1.txt", context), image,color),
                    new BhajaneData(ch_names[2].toString(),readPageFromAssetFile("kannada/page2.txt", context), image,color),
                    new BhajaneData(ch_names[3].toString(),readPageFromAssetFile("kannada/page3.txt", context), image,color),
                    new BhajaneData(ch_names[4].toString(),readPageFromAssetFile("kannada/page4.txt", context), image,color),
                    new BhajaneData(ch_names[5].toString(),readPageFromAssetFile("kannada/page5.txt", context), image,color),
                    new BhajaneData(ch_names[6].toString(),readPageFromAssetFile("kannada/page6.txt", context), image,color),
                    new BhajaneData(ch_names[7].toString(),readPageFromAssetFile("kannada/page7.txt", context), image,color),
                    new BhajaneData(ch_names[8].toString(),readPageFromAssetFile("kannada/page8.txt", context), image,color),
                    new BhajaneData(ch_names[9].toString(),readPageFromAssetFile("kannada/page9.txt", context), image,color),
                    new BhajaneData(ch_names[10].toString(),readPageFromAssetFile("kannada/page10.txt", context), image,color),
                    new BhajaneData(ch_names[11].toString(),readPageFromAssetFile("kannada/page11.txt", context), image,color),
                    new BhajaneData(ch_names[12].toString(),readPageFromAssetFile("kannada/page12.txt", context), image,color),
                    new BhajaneData(ch_names[13].toString(),readPageFromAssetFile("kannada/page13.txt", context), image,color)
                };

        return myListData;
    }

    private static String readPageFromAssetFile(String filename, Context context) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        try {
            InputStream is = context.getAssets().open(filename);
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String str;

            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append(System.getProperty("line.separator"));
                sb.append("<br>");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String retStr =  sb.toString();
        return retStr;
    }
}
