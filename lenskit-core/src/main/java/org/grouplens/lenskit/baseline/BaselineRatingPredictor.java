/*
 * LensKit, a reference implementation of recommender algorithms.
 * Copyright 2010-2011 Regents of the University of Minnesota
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.grouplens.lenskit.baseline;

import java.util.Collection;

import org.grouplens.lenskit.AbstractDynamicRatingPredictor;
import org.grouplens.lenskit.DynamicRatingPredictor;
import org.grouplens.lenskit.data.dao.RatingDataAccessObject;
import org.grouplens.lenskit.data.vector.SparseVector;

/**
 * {@link DynamicRatingPredictor} that delegates to the baseline predictor.  This
 * allows baseline predictors to be used as rating predictors in their own right.
 * 
 * @author Michael Ekstrand <ekstrand@cs.umn.edu>
 * @see BaselinePredictor
 */
public class BaselineRatingPredictor extends AbstractDynamicRatingPredictor {
    private BaselinePredictor predictor;

    /**
     * Construct a new baseline rating predictor.
     * @param baseline The predictor to delegate to
     * @param dao The DAO.
     */
    public BaselineRatingPredictor(BaselinePredictor baseline, RatingDataAccessObject dao) {
        super(dao);
        predictor = baseline;
    }

    @Override
    public SparseVector predict(long user, SparseVector ratings,
        Collection<Long> items) {
        return predictor.predict(user, ratings, items);
    }

}
