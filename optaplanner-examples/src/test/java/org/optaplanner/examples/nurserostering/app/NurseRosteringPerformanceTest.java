/*
 * Copyright 2011 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.examples.nurserostering.app;

import java.util.stream.Stream;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.config.solver.EnvironmentMode;
import org.optaplanner.examples.common.app.SolverPerformanceTest;
import org.optaplanner.examples.nurserostering.domain.NurseRoster;

public class NurseRosteringPerformanceTest extends SolverPerformanceTest<NurseRoster, HardSoftScore> {

    private static final String UNSOLVED_DATA_FILE = "data/nurserostering/unsolved/medium_late01_initialized.xml";

    @Override
    protected NurseRosteringApp createCommonApp() {
        return new NurseRosteringApp();
    }

    @Override
    protected Stream<TestData<HardSoftScore>> testData() {
        return Stream.of(
                testData(UNSOLVED_DATA_FILE, HardSoftScore.ofSoft(-568), EnvironmentMode.REPRODUCIBLE),
                testData(UNSOLVED_DATA_FILE, HardSoftScore.ofSoft(-689), EnvironmentMode.FAST_ASSERT));
    }
}
