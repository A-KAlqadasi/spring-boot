package com.amigoscode.common.results;


import com.amigoscode.common.results.markers.Created;
import com.amigoscode.common.results.markers.Deleted;
import com.amigoscode.common.results.markers.Success;
import com.amigoscode.common.results.markers.Updated;

public final class Results {

    private Results() {}

    public static final Success SUCCESS = new Success();
    public static final Created CREATED = new Created();
    public static final Deleted DELETED = new Deleted();
    public static final Updated UPDATED = new Updated();
}
