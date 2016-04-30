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

import java.util.Objects;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntBiFunction;

public interface CurryingIntUnaryOperator extends IntUnaryOperator {

    default CurryingIntSupplier curry(int i) {
        return () -> this.applyAsInt(i);
    }

    default <V, U> CurryingToIntBiFunction<V, U> compose(ToIntBiFunction<? super V, ? super U> before) {
        Objects.requireNonNull(before);
        return (v, u) -> this.applyAsInt(before.applyAsInt(v, u));
    }

}
