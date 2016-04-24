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

import java.util.function.LongBinaryOperator;

public interface CurryingLongBinaryOperator extends LongBinaryOperator {

    default CurryingLongUnaryOperator curry(long l) {
        return (l2) -> this.applyAsLong(l, l2);
    }

    default CurryingLongSupplier curry(long l, long l2) {
        return () -> this.applyAsLong(l, l2);
    }

    default CurryingLongBinaryOperator flip() {
        return (l2, l) -> this.applyAsLong(l, l2);
    }

}
