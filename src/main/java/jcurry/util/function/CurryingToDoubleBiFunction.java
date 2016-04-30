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
package jcurry.util.function;

import java.util.function.ToDoubleBiFunction;

public interface CurryingToDoubleBiFunction<T, U> extends ToDoubleBiFunction<T, U> {

    default CurryingToDoubleFunction<U> curry(T t) {
        return (u) -> this.applyAsDouble(t, u);
    }

    default CurryingDoubleSupplier curry(T t, U u) {
        return () -> this.applyAsDouble(t, u);
    }

    default CurryingToDoubleBiFunction<U, T> flip() {
        return (u, t) -> this.applyAsDouble(t, u);
    }

}
