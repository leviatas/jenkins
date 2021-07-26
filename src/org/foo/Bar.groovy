package org.foo

import groovy.json.JsonSlurper

class Bar {

    static String loadName(String key) {
        def json = new JsonSlurper().parse(Bar.getResourceAsStream("bar.json"))
        return json.names[key]
    }

}
