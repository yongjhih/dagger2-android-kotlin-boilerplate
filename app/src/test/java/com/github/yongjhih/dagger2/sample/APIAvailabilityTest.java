package com.github.yongjhih.dagger2.sample;

import android.os.Build;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;
import com.google.common.io.Resources;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.List;

import br.ufs.github.rxassertions.RxAssertions;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

import static org.assertj.core.api.Assertions.*;

public class APIAvailabilityTest {

    @Test public void testReachable() throws Exception {
        OkHttpClient okhttpclient = new OkHttpClient.Builder().build();
        Call call = okhttpclient.newCall(new Request.Builder().get().url("https:/api.github.com/v3/users/yongjhih/repos").build());
        Response resp = call.execute();
        assertThat(resp.isSuccessful()).isTrue();
    }

    //@Test public void testGitHub() throws IOException, ParseException {
    //    MockWebServer mockWebServer = new MockWebServer();
    //    OkHttpClient.Builder client = new OkHttpClient.Builder();
    //    GitHub gitHub = new Retrofit.Builder()
    //            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
    //            .addConverterFactory(LoganSquareConverterFactory.create())
    //            .baseUrl(mockWebServer.url("").toString())
    //            .client(client.build())
    //            .build().create(GitHub.class);
    //    //String repos = Resources.toString(getClass().getClassLoader().getResource("repos.json"), StandardCharsets.UTF_8);
    //    //mockWebServer.enqueue(new MockResponse().setBody(repos));
    //    RxAssertions.assertThat(github.repos("yongjhih"))
    //            .take(1)
    //            .map(repo -> owner.login))
    //            .expectedSingleValue("yongjhih");
    //}
}
