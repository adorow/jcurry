/*
   Copyright 2016 Anderson Dorow

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package jcurry.function;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.IntSupplier;

public interface CurryingIntSupplier extends IntSupplier {

    default <R> CurryingSupplier<R> andThen(DoubleFunction<? extends R> after) {
        return () -> after.apply(this.getAsInt());
    }

    default <U, R> CurryingFunction<U, R> andThenComposeInto(BiFunction<Integer, ? super U, ? extends R> after) {
        return (u) -> after.apply(this.getAsInt(), u);
    }

}
