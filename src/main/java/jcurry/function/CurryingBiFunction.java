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

public interface CurryingBiFunction<T, U, R> extends BiFunction<T, U, R> {

    default CurryingFunction<U, R> curry(T t) {
        return (u) -> this.apply(t, u);
    }

    default CurryingSupplier<R> curry(T t, U u) {
        return () -> this.apply(t, u);
    }

    default CurryingBiFunction<U, T, R> flip() {
        return (u, t) -> this.apply(t, u);
    }

}
