package com.outseta.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.outseta.model.BaseResult;

import java.util.List;

public class MultiplePerson implements BaseResult {

    @JsonProperty("metadata")
    private Metadata metadata;

    @JsonProperty("items")
    private List<Person> items;

    public MultiplePerson() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Person> getItems() {
        return items;
    }

    public void setItems(List<Person> items) {
        this.items = items;
    }
}
