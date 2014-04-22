package org.semanticweb.owlapi.search;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.util.OWLAxiomVisitorExAdapter;

@SuppressWarnings("unchecked")
class DomainRangeVisitor<C extends OWLObject> extends
        OWLAxiomVisitorExAdapter<C> {

    private static final long serialVersionUID = 40000L;
    private boolean range;

    public DomainRangeVisitor(boolean range) {
        this.range = range;
    }

    @Nullable
    @Override
    public C visit(@Nonnull OWLAnnotationPropertyDomainAxiom axiom) {
        if (!range) {
            return (C) axiom.getDomain();
        }
        return null;
    }

    @Nullable
    @Override
    public C visit(@Nonnull OWLAnnotationPropertyRangeAxiom axiom) {
        if (range) {
            return (C) axiom.getRange();
        }
        return null;
    }

    @Nullable
    @Override
    public C visit(@Nonnull OWLDataPropertyDomainAxiom axiom) {
        if (!range) {
            return (C) axiom.getDomain();
        }
        return null;
    }

    @Nullable
    @Override
    public C visit(@Nonnull OWLDataPropertyRangeAxiom axiom) {
        if (range) {
            return (C) axiom.getRange();
        }
        return null;
    }

    @Nullable
    @Override
    public C visit(@Nonnull OWLObjectPropertyDomainAxiom axiom) {
        if (!range) {
            return (C) axiom.getDomain();
        }
        return null;
    }

    @Nullable
    @Override
    public C visit(@Nonnull OWLObjectPropertyRangeAxiom axiom) {
        if (range) {
            return (C) axiom.getRange();
        }
        return null;
    }
}