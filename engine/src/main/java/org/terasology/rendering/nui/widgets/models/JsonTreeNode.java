/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.rendering.nui.widgets.models;

import com.google.gson.JsonElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The value type for the tree representation of a {@link JsonElement}.
 */
public class JsonTreeNode {
    private static final Logger logger = LoggerFactory.getLogger(JsonTreeNode.class);

    /**
     * The type of the JSON node.
     */
    public enum ElementType {
        /**
         * Primitive data type (string, boolean, array).
         */
        VALUE,
        /**
         * A primitive data type paired with a key string.
         */
        KEY_VALUE_PAIR,
        /**
         * An ordered list of zero or more values.
         */
        ARRAY,
        /**
         * An unordered list of name/value pairs.
         */
        OBJECT,
        /**
         * An empty value.
         */
        NULL
    }

    /**
     * The default name for a JSON object node.
     */
    private static final String OBJECT_STRING = "{}";
    /**
     * The default name for a JSON array node.
     */
    private static final String ARRAY_STRING = "[]";
    /**
     * The default name for a null JSON node.
     */
    private static final String NULL_STRING = "null";
    /**
     * The name of the node.
     */
    private String key;
    /**
     * The value stored within the node.
     */
    private Object value;
    /**
     * The type of the node.
     */
    private ElementType type;

    public JsonTreeNode(String key, Object value, ElementType type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public String getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public ElementType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        if (type == ElementType.KEY_VALUE_PAIR) {
            if (key != null && value != null) {
                return key + ": " + value;
            }
            return key == null ? value.toString() : key;
        } else if (type == ElementType.VALUE) {
            return value.toString();
        } else if (type == ElementType.ARRAY) {
            return key != null ? key : ARRAY_STRING;
        } else if (type == ElementType.OBJECT) {
            System.out.println(key);
            return key != null ? key : OBJECT_STRING;
        } else {
            return key != null ? key : NULL_STRING;
        }
    }
}
