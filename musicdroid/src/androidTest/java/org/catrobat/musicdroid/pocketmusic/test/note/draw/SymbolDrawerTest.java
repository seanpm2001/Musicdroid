/*
 * Musicdroid: An on-device music generator for Android
 * Copyright (C) 2010-2014 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.musicdroid.pocketmusic.test.note.draw;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;

import org.catrobat.musicdroid.pocketmusic.note.MusicalKey;
import org.catrobat.musicdroid.pocketmusic.note.draw.NoteSheetCanvas;
import org.catrobat.musicdroid.pocketmusic.note.draw.NoteSheetDrawPosition;
import org.catrobat.musicdroid.pocketmusic.note.draw.SymbolDrawer;
import org.catrobat.musicdroid.pocketmusic.note.symbol.Symbol;

public class SymbolDrawerTest extends AbstractDrawerTest {

    private NoteSheetDrawPosition drawPosition;
    private SymbolDrawerMock symbolDrawer;

    @Override
    protected void setUp() {
        super.setUp();

        drawPosition = new NoteSheetDrawPosition(START_X_POSITION, END_X_POSITION);
        symbolDrawer = new SymbolDrawerMock(noteSheetCanvas, paint, getContext().getResources(), MusicalKey.VIOLIN, drawPosition,DISTANCE_BETWEEN_LINES);
    }

    public void testGetCenterPointForNextSymbol() {
        Point expectedPoint = new Point(calculateStartX(symbolDrawer.getWidthForOneSymbol()), noteSheetCanvas.getHeightHalf());
        Point actualPoint = symbolDrawer.getCenterPointForNextSymbol();

        assertEquals(expectedPoint, actualPoint);
    }

    public void testGetCenterPointForNextSmallSymbol() {
        Point expectedPoint = new Point(calculateStartX(symbolDrawer.getWidthForOneSmallSymbol()), noteSheetCanvas.getHeightHalf());
        Point actualPoint = symbolDrawer.getCenterPointForNextSmallSymbol();

        assertEquals(expectedPoint, actualPoint);
    }

    private int calculateStartX(int symbolWidth) {
        return drawPosition.getStartXPositionForNextElement() + (symbolWidth / 2);
    }
}
