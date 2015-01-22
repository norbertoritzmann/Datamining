/*
 * jCandle, an application for technical chart analysis.
 * Copyright (C) 2012 Hansgeorg Schwibbe. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/]. 
 */
package timeseries.csv;

/**
 * This expression implementation interprets inverted commas from the CSV context.
 * 
 * @author Hansgeorg Schwibbe
 */
public final class InvertedCommaExpression implements CsvExpression {

    @Override
    public String interpret(final StringBuilder context) {
        if (context.charAt(0) == '\"') {
            final int indexOfNextInvertedComma = context.indexOf("\"", 1);
            if (indexOfNextInvertedComma > 0) {
                final String value = context.substring(1, indexOfNextInvertedComma);
                context.delete(0, indexOfNextInvertedComma + 1);
                return value;
            }
        }
        return null;
    }
}