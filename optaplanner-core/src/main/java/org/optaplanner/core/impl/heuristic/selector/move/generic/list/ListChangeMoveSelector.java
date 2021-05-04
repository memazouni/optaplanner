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

import java.util.Iterator;

import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.core.impl.heuristic.selector.entity.EntitySelector;
import org.optaplanner.core.impl.heuristic.selector.move.generic.GenericMoveSelector;

public class ListChangeMoveSelector<Solution_> extends GenericMoveSelector<Solution_> {

    private final EntitySelector<Solution_> entitySelector;
    private final DefaultListVariableDescriptor<Solution_> listVariableDescriptor;

    public ListChangeMoveSelector(
            EntitySelector<Solution_> entitySelector,
            DefaultListVariableDescriptor<Solution_> listVariableDescriptor) {
        this.entitySelector = entitySelector;
        this.listVariableDescriptor = listVariableDescriptor;
    }

    @Override
    public long getSize() {
        // TODO value count * (value count + entity count - 2)
        return 9;
    }

    @Override
    public Iterator<Move<Solution_>> iterator() {
        return new NaiveListChangeIterator<>(entitySelector, listVariableDescriptor);
    }

    @Override
    public boolean isCountable() {
        return true;
    }

    @Override
    public boolean isNeverEnding() {
        return false;
    }
}