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
        int image = R.drawable.rama_lakshmana_seethe;
        int color = Color.parseColor("#ffffff");
        BhajaneData[] myListData;

        String[] ch_names = context.getResources().getStringArray(R.array.contents);
        myListData =
            new BhajaneData[]
                {
                    new BhajaneData(ch_names[0].toString(), readPageFromAssetFile("page1.txt", context), image, color),
                    new BhajaneData(ch_names[1].toString(),readPageFromAssetFile("page2.txt", context), image,color),
                    new BhajaneData(ch_names[2].toString(),"Page3", image, color),
                    new BhajaneData(ch_names[3].toString(),"Page4", image, color),
                    new BhajaneData(ch_names[4].toString(),"Page5", image, color),
                    new BhajaneData(ch_names[5].toString(),"Page6", image, color),
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
