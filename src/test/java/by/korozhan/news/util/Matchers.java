package by.korozhan.news.util;

import org.bson.types.ObjectId;
import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;

public final class Matchers {
    public static Matcher<String> validJsonId() {
        return new CustomTypeSafeMatcher<String>("id should be org.bson.types.ObjectId compatible") {
            @Override
            protected boolean matchesSafely(String hexStringId) {
                return ObjectId.isValid(hexStringId);
            }
        };
    }


    private Matchers() {
        throw new AssertionError();
    }
}
