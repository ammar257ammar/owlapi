/* This file is part of the OWL API.
 * The contents of this file are subject to the LGPL License, Version 3.0.
 * Copyright 2014, The University of Manchester
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0 in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License. */
package org.semanticweb.owlapi6.api.test.baseclasses;

import static org.semanticweb.owlapi6.api.test.TestEntities.A;
import static org.semanticweb.owlapi6.api.test.TestEntities.B;
import static org.semanticweb.owlapi6.api.test.TestEntities.C;
import static org.semanticweb.owlapi6.api.test.TestEntities.D;
import static org.semanticweb.owlapi6.api.test.TestEntities.DP;
import static org.semanticweb.owlapi6.api.test.TestEntities.DQ;
import static org.semanticweb.owlapi6.api.test.TestEntities.DR;
import static org.semanticweb.owlapi6.api.test.TestEntities.I;
import static org.semanticweb.owlapi6.api.test.TestEntities.J;
import static org.semanticweb.owlapi6.api.test.TestEntities.P;
import static org.semanticweb.owlapi6.api.test.TestEntities.Q;
import static org.semanticweb.owlapi6.api.test.TestEntities.R;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.AsymmetricObjectProperty;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.ClassAssertion;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.DataPropertyAssertion;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.DataPropertyDomain;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.DataPropertyRange;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.DisjointClasses;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.DisjointDataProperties;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.DisjointObjectProperties;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.EquivalentClasses;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.EquivalentDataProperties;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.EquivalentObjectProperties;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.FunctionalDataProperty;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.FunctionalObjectProperty;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.InverseFunctionalObjectProperty;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.IrreflexiveObjectProperty;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.Literal;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.NegativeDataPropertyAssertion;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.NegativeObjectPropertyAssertion;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.ObjectPropertyAssertion;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.ObjectPropertyDomain;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.ObjectPropertyRange;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.ReflexiveObjectProperty;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.SubDataPropertyOf;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.SubObjectPropertyOf;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.SubPropertyChainOf;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.SymmetricObjectProperty;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.TopDatatype;
import static org.semanticweb.owlapi6.apibinding.OWLFunctionalSyntaxFactory.TransitiveObjectProperty;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.semanticweb.owlapi6.model.OWLAnnotation;
import org.semanticweb.owlapi6.model.OWLAxiom;

/**
 * @author Matthew Horridge, The University of Manchester, Information
 *         Management Group
 * @since 3.0.0
 */
@RunWith(Parameterized.class)
public class AnnotatedAxiomRountripTestCase extends AnnotatedAxiomRoundTrippingTestCase {

    public AnnotatedAxiomRountripTestCase(Function<List<OWLAnnotation>, OWLAxiom> f) {
        super(f);
    }

    @Parameters
    public static List<Function<List<OWLAnnotation>, OWLAxiom>> getData() {
        return Arrays.asList(a -> AsymmetricObjectProperty(P, a), a -> ClassAssertion(A, I, a),
            a -> DataPropertyAssertion(DP, I, Literal("xyz"), a), a -> DataPropertyDomain(DP, A, a),
            a -> DataPropertyRange(DP, TopDatatype(), a), a -> DisjointClasses(a, A, B),
            a -> DisjointClasses(a, A, B, C, D), a -> DisjointDataProperties(a, DP, DQ),
            a -> DisjointDataProperties(a, DP, DQ, DR), a -> DisjointObjectProperties(a, P, Q),
            a -> DisjointObjectProperties(a, P, Q, R), a -> EquivalentClasses(a, A, B),
            a -> EquivalentDataProperties(a, DP, DQ), a -> EquivalentObjectProperties(a, P, Q),
            a -> FunctionalDataProperty(DP, a), a -> FunctionalObjectProperty(P, a),
            a -> InverseFunctionalObjectProperty(P, a), a -> IrreflexiveObjectProperty(P, a),
            a -> NegativeDataPropertyAssertion(DP, I, Literal("xyz"), a),
            a -> NegativeObjectPropertyAssertion(P, I, J, a), a -> ObjectPropertyAssertion(P, I, J, a),
            a -> ObjectPropertyDomain(P, A, a), a -> ObjectPropertyRange(P, A, a), a -> ReflexiveObjectProperty(P, a),
            a -> df.getOWLSubClassOfAxiom(A, B, a), a -> SubDataPropertyOf(DP, DQ, a),
            a -> SubObjectPropertyOf(P, Q, a), a -> SymmetricObjectProperty(P, a), a -> TransitiveObjectProperty(P, a),
            a -> SubPropertyChainOf(Arrays.asList(P, Q), R, a));
    }
}