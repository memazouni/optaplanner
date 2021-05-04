/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.core.impl.heuristic.selector.move.generic.list;

import static org.optaplanner.core.impl.testdata.util.PlannerAssert.assertAllCodesOfMoveSelector;

import org.junit.jupiter.api.Test;
import org.optaplanner.core.impl.heuristic.selector.SelectorTestUtils;
import org.optaplanner.core.impl.heuristic.selector.entity.EntitySelector;
import org.optaplanner.core.impl.testdata.domain.TestdataValue;
import org.optaplanner.core.impl.testdata.domain.list.TestdataListEntity;

class ListChangeMoveSelectorTest {

    @Test
    <Solution_> void naive() {
        TestdataValue v1 = new TestdataValue("1");
        TestdataValue v2 = new TestdataValue("2");
        TestdataValue v3 = new TestdataValue("3");
        EntitySelector<Solution_> entitySelector = SelectorTestUtils.mockEntitySelector(
                TestdataListEntity.class,
                new TestdataListEntity("A", v1, v2),
                new TestdataListEntity("B", v3));
        ListChangeMoveSelector<Solution_> moveSelector =
                new ListChangeMoveSelector<>(entitySelector, TestdataListEntity.buildVariableDescriptorForValueList());

        assertAllCodesOfMoveSelector(moveSelector,
                "A[0]->A[0]", "A[0]->A[1]", "A[0]->B[0]",
                "A[1]->A[0]", "A[1]->A[1]", "A[1]->B[0]",
                "B[0]->A[0]", "B[0]->A[1]", "B[0]->B[0]");
    }
}