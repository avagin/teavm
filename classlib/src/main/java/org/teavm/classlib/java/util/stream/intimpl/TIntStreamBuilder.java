/*
 *  Copyright 2017 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.classlib.java.util.stream.intimpl;

import java.util.Arrays;
import org.teavm.classlib.java.util.TArrays;
import org.teavm.classlib.java.util.stream.TIntStream;

public class TIntStreamBuilder implements TIntStream.Builder {
    private int[] elements = new int[4];
    private int size;

    @Override
    public void accept(int t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = t;
    }

    @Override
    public TIntStream build() {
        return TArrays.stream(elements, 0, size);
    }
}
