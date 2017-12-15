


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;
import static org.junit.Assert.assertTrue;


/**
 * Created by emilasberg on 2017-09-12.
 */
public class APIWrapperTest {
    private APIWrapper wrapper;

    @org.junit.Before
    public void setUp() throws Exception {
        String key = System.getenv("API_KEY");
        wrapper = new APIWrapper(key);
    }

    @org.junit.Test
    public void search() throws Exception {
        Parameters parameters = new Parameters()
                .addSearch("mass effect")
                .addFields("*");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.search(APIWrapper.Endpoint.GAMES, parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                try {
                    lock.countDown();
                    JSONObject gameObject = result.getJSONObject(0);
                    String name = gameObject.getString("name");
                    String url = gameObject.getString("url");
                    assertTrue(url.equals("https://www.igdb.com/games/mass-effect"));
                    assertTrue(name.equals("Mass Effect"));

                } catch (JSONException e) {
                    fail("JSONException! " + e.getMessage());
                }
            }

            @Override
            public void onError(Exception error) {
                fail("Received HTTP error: " + error.getCause());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);


    }

    @org.junit.Test
    public void games() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("12356");


        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.games(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                try {
                    lock.countDown();
                    JSONObject jo = result.getJSONObject(0);
                    String s = jo.getString("slug");
                    assertTrue(s.equals("3d-quasars"));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }
            }

            @Override
            public void onError(Exception error) {
                System.out.println("Query:  Error in games: " + error.getMessage());
                Assert.fail();
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);
    }

    @org.junit.Test
    public void pulse() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("12342");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.pulses(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("title");
                    assertTrue(s.equals("A First Look Inside the Sailor Moon Museum Exhibit"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();                }

            }

            @Override
            public void onError(Exception error) {
                Assert.fail();            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void characters() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("6");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.characters(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Commander Shepard (female)"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void collections() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("6");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.collections(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("The Elder Scrolls"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void companies() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("6");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.companies(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Lionhead Studios"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void franchises() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("6");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.franchises(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Warhammer 40,000"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void feeds() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("4011");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.feeds(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("pulse");
                    assertTrue(s.equals("24221"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void pages() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("6");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.pages(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("theRadBrad"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void gameEngines() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("6");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.gameEngines(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Unreal Engine"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);
    }

    @org.junit.Test
    public void gameModes() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("5");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.gameModes(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Massively Multiplayer Online (MMO)"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void genres() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("5");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.genres(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Shooter"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void keywords() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("5");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.keywords(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("zombies"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void people() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("5");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.people(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("David Falkner"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void platforms() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("5");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.platforms(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Wii"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    fail(e.getMessage());
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void playerPerspectives() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("5");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.playerPerspectives(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Text"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void releaseDates() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("4");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.releaseDates(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("human");
                    assertTrue(s.equals("2008-Oct-20"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);
    }

    @org.junit.Test
    public void pulseGroups() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("1254");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.pulseGroups(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Marvel vs. Capcom: Infinite"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);
    }

    @org.junit.Test
    public void pulseSources() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("1");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.pulseSources(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Kotaku"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void themes() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("42");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.themes(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Erotic"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);
    }

    @org.junit.Test
    public void reviews() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("42");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.reviews(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("title");
                    assertTrue(s.equals("This is a game"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);

    }

    @org.junit.Test
    public void titles() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("42");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.titles(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("name");
                    assertTrue(s.equals("Assistant External Resources Producer"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);
    }

    @org.junit.Test
    public void credits() throws Exception {
        Parameters parameters = new Parameters()
                .addIds("1073987150");

        final CountDownLatch lock = new CountDownLatch(1);
        wrapper.credits(parameters, new APIWrapper.onSuccessCallback() {
            @Override
            public void onSuccess(JSONArray result) {
                JSONObject jo;
                try {
                    lock.countDown();
                    jo = result.getJSONObject(0);
                    String s = jo.getString("game");
                    assertTrue(s.equals("493"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Assert.fail();
                }

            }

            @Override
            public void onError(Exception error) {
                fail(error.getMessage());
            }
        });
        lock.await(20000, TimeUnit.MILLISECONDS);
    }

}