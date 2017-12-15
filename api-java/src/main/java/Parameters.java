import java.util.ArrayList;

public class Parameters {

    private ArrayList<String> filters = new ArrayList<>();
    private String offset = "";
    private String ids = "";
    private String fields = "";
    private String expand = "";
    protected String limit = "";
    private String order = "";
    private String search = "";
    protected String scroll = "";
    private String query = "";

    /**
     * This parameter adds a filter to the query.
     *
     * @param filter    The filter param is a string for the intended filter,
     *                  Example for input: "[id][eq]=1337"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addFilter(String filter) {
        filters.add( ("&filter" + filter).replaceAll(" ",""));
        return this;
    }

    /**
     * This parameter adds id(s) to the query.
     *
     * @param ids       The ids param is a string of the ids,
     *                  Example for input: "1336,1337,45"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addIds(String ids){
        this.ids = ids.replaceAll(" ", "");
        return this;
    }

    /**
     * This parameter adds a page offset to the query.
     *
     * @param offset    The offset param is a string number,
     *                  Example for input: "2"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addOffset(String offset){
        this.offset = "&offset=" + offset.replaceAll(" ", "");
        return this;
    }

    /**
     * This parameter adds the resulting fields to the query.
     *
     * @param fields    The fields param is a string of properties,
     *                  Example for input: "id,name,first_release_date"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addFields(String fields){
        this.fields = fields.replaceAll(" ", "");
        return this;
    }

    /**
     * This parameter adds the expanded properties to the resulting query.
     *
     * @param expand    The expand param is a string of properties,
     *                  Example for input: "game,platforms,release_dates"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addExpand(String expand) {
        this.expand ="&expand=" + expand.replaceAll(" ", "");
        return this;
    }

    /**
     * This parameter adds a list limit to the query.
     *
     * @param limit     The limit param is a string number,
     *                  Example for input: "2"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addLimit(String limit) {
        this.limit = "&limit=" + limit.replaceAll(" ", "");
        return this;
    }

    /**
     * This parameter adds ordering to the query.
     *
     * @param order     The order param is a string of an property and ordering,
     *                  Example for input: "popularity:desc"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addOrder(String order){
        this.order = "&order=" + order.replaceAll(" ", "");
        return this;
    }

    /**
     * This parameter adds search term to the query.
     *
     * @param search    The search param is the search term,
     *                  Example for input: "zelda"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addSearch(String search){
        this.search= "?search=" + search.replaceAll(" ", "%20");
        return this;
    }

    /**
     * This parameter adds scroll param to the query.
     *
     * @param scroll    The scroll param activates the scroll api,
     *                  Example for input: "1"
     *
     * @return this     Returns itself to build on the query.
     **/
    public Parameters addScroll(String scroll){
        this.scroll = "&scroll=" + scroll.replaceAll(" ", "");
        return this;
    }

    /**
     * This method builds the query out of the params given
     *
     * @param endpoint  The endpoint sets the desired andpoint for the params.
     *
     * @return String   Returns a finished string query ready for http requests
     **/
    public String buildQuery(APIWrapper.Endpoint endpoint) {
        String filter = "";
        for (String s: filters) {
            filter += s;
        }

        query = endpoint.toString().toLowerCase();
        query += "/" + ids + search;

        if (fields != "" && search != ""){
            query += "&fields=" + fields;
        }else if (!fields.isEmpty()){
            query += "?fields=" + fields;
        }else{
            query += "?fields=*";
        }

        query += filter + expand + order + limit + offset + scroll;
        System.out.println("Query: " + query);
        return query;
    }

}