/*
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserved.
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

package io.crate.analyze;

import io.crate.sql.tree.DefaultTraversalVisitor;
import io.crate.sql.tree.Node;
import io.crate.sql.tree.ShowGrants;

import org.elasticsearch.common.inject.Inject;

public class ShowGrantsStatementAnalyzer extends DefaultTraversalVisitor<ShowGrantsAnalyzedStatement, Analysis> {

    @Inject
    public ShowGrantsStatementAnalyzer() {
    }

    @Override
    public ShowGrantsAnalyzedStatement visitShowGrants(ShowGrants node, Analysis context) {
        ShowGrantsAnalyzedStatement statement = new ShowGrantsAnalyzedStatement(node.getUsername());
        return statement;
    }

    public ShowGrantsAnalyzedStatement analyze(Node node, Analysis analysis) {
        analysis.expectsAffectedRows(false);
        return process(node, analysis);
    }
}