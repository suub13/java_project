package com.project;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class data {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_pmntn_api"); /*URL*/
        String encodingKey = "oE65N4LDV1qsVSi751kDr9stYP2D9X2kfUWyfSqJrxmBgWnEpz8Pqy3%2FfGquC1seQY7%2BMNYwFteqOqa9UDZDKQ%3D%3D";
        String decodingKey = "oE65N4LDV1qsVSi751kDr9stYP2D9X2kfUWyfSqJrxmBgWnEpz8Pqy3/fGquC1seQY7+MNYwFteqOqa9UDZDKQ==";
        String encoded = "oE65N4LDV1qsVSi751kDr9stYP2D9X2kfUWyfSqJrxmBgWnEpz8Pqy3%2FfGquC1seQY7%2BMNYwFteqOqa9UDZDKQ%3D%3D";
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + encoded); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*XML/JSON 여부*/
        urlBuilder.append("&" + URLEncoder.encode("mntnCode","UTF-8") + "=" + URLEncoder.encode("292000101", "UTF-8")); /*산코드*/
        urlBuilder.append("&" + URLEncoder.encode("mntnNm","UTF-8") + "=" + URLEncoder.encode("어등산", "UTF-8")); /*산명*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*등산로순번*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnNm","UTF-8") + "=" + URLEncoder.encode("어등산 1-1코스", "UTF-8")); /*등산로명*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnSpotDc","UTF-8") + "=" + URLEncoder.encode("광주여대 - 산정약수터", "UTF-8")); /*등산로주요지점내용*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnLt","UTF-8") + "=" + URLEncoder.encode("2.5", "UTF-8")); /*등산로길이*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnDfflyNm","UTF-8") + "=" + URLEncoder.encode("중간", "UTF-8")); /*등산로난이도명*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnUpplnTime","UTF-8") + "=" + URLEncoder.encode("48", "UTF-8")); /*등산로상행시간*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnGodnTime","UTF-8") + "=" + URLEncoder.encode("33", "UTF-8")); /*등산로하행시간*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnMtrqltDc","UTF-8") + "=" + URLEncoder.encode("육산(95), 암릉(5)", "UTF-8")); /*등산로재질내용*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnCnrlYn","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*등산로통제여부*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnClsYn","UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*등산로폐쇄여부*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnRiskSctnDc","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*등산로위험구간내용*/
        urlBuilder.append("&" + URLEncoder.encode("pmntnRecomendYn","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*등산로추천여부*/
        urlBuilder.append("&" + URLEncoder.encode("referenceDate","UTF-8") + "=" + URLEncoder.encode("2019-01-01", "UTF-8")); /*데이터기준일자*/
        urlBuilder.append("&" + URLEncoder.encode("insttCode","UTF-8") + "=" + URLEncoder.encode("3630000", "UTF-8")); /*제공기관코드*/
        urlBuilder.append("&" + URLEncoder.encode("insttNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관명*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}