/*
 * $Id$ 
 *
 * Copyright 1999-2004 The Apache Software Foundation.
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

package org.apache.tiles;

import java.io.IOException;

/**
 * A controller is a piece of code called before rendering a jsp page.
 * A controller can be associated to a tile. See &lt;insert&gt; or 
 * &lt;definition&gt; for association syntax.
 */
public interface Controller {

    /**
     * Method associated to a tile and called immediately before the tile 
     * is included.
     * @param tilesContext Current tiles application context.
     * @param componentContext Current tile context.
     */
    public void execute(
            TilesContext tilesContext, 
            ComponentContext componentContext)
            throws Exception;
}