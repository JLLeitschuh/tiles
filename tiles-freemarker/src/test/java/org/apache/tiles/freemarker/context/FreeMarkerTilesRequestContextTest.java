package org.apache.tiles.freemarker.context;

import static org.junit.Assert.*;
import static org.easymock.classextension.EasyMock.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;

import org.apache.tiles.context.TilesRequestContext;
import org.junit.Before;
import org.junit.Test;

import freemarker.core.Environment;
import freemarker.template.Template;
import freemarker.template.TemplateHashModel;

/**
 * @author antonio
 *
 */
public class FreeMarkerTilesRequestContextTest {

    /**
     * The reuqest context to test.
     */
    private FreeMarkerTilesRequestContext context;
    
    /**
     * A string writer.
     */
    private StringWriter writer;

    /**
     * The FreeMarker environment.
     */
    private Environment env;
    
    /**
     * The locale object.
     */
    private Locale locale;
    
    /**
     * @throws java.lang.Exception If something goes wrong.
     */
    @Before
    public void setUp() throws Exception {
        Template template = createMock(Template.class);
        TemplateHashModel model = createMock(TemplateHashModel.class);
        writer = new StringWriter();
        expect(template.getMacros()).andReturn(new HashMap<Object, Object>());
        replay(template, model);
        env = new Environment(template, model, writer);
        locale = Locale.ITALY;
        env.setLocale(locale);
    }

    /**
     * Tests {@link FreeMarkerTilesRequestContext#dispatch(String)}.
     * 
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testDispatch() throws IOException {
        String path = "this way";
        TilesRequestContext enclosedRequest = createMock(TilesRequestContext.class);
        enclosedRequest.include(path);
        replay(enclosedRequest);
        context = new FreeMarkerTilesRequestContext(enclosedRequest, env);
        context.dispatch(path);
        verify(enclosedRequest);
    }

    /**
     * Tests {@link FreeMarkerTilesRequestContext#getRequestLocale()}.
     */
    @Test
    public void testGetRequestLocale() {
        TilesRequestContext enclosedRequest = createMock(TilesRequestContext.class);
        replay(enclosedRequest);
        context = new FreeMarkerTilesRequestContext(enclosedRequest, env);
        assertEquals(locale, context.getRequestLocale());
        verify(enclosedRequest);
    }

    /**
     * Tests {@link FreeMarkerTilesRequestContext#getRequest()}.
     */
    @Test
    public void testGetRequest() {
        TilesRequestContext enclosedRequest = createMock(TilesRequestContext.class);
        replay(enclosedRequest);
        context = new FreeMarkerTilesRequestContext(enclosedRequest, env);
        assertEquals(env, context.getRequest());
        verify(enclosedRequest);
    }

    /**
     * Tests {@link FreeMarkerTilesRequestContext#getResponse()}.
     */
    @Test
    public void testGetResponse() {
        TilesRequestContext enclosedRequest = createMock(TilesRequestContext.class);
        replay(enclosedRequest);
        context = new FreeMarkerTilesRequestContext(enclosedRequest, env);
        assertEquals(env, context.getResponse());
        verify(enclosedRequest);
    }

    /**
     * Tests {@link FreeMarkerTilesRequestContext#getPrintWriter()}.
     * 
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetPrintWriter() throws IOException {
        TilesRequestContext enclosedRequest = createMock(TilesRequestContext.class);

        replay(enclosedRequest);
        context = new FreeMarkerTilesRequestContext(enclosedRequest, env);
        assertEquals(env, context.getResponse());
        assertNotNull(context.getPrintWriter());
        verify(enclosedRequest);
    }

    /**
     * Tests {@link FreeMarkerTilesRequestContext#getWriter()}.
     * 
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetWriter() throws IOException {
        TilesRequestContext enclosedRequest = createMock(TilesRequestContext.class);

        replay(enclosedRequest);
        context = new FreeMarkerTilesRequestContext(enclosedRequest, env);
        assertEquals(env, context.getResponse());
        assertNotNull(context.getWriter());
        verify(enclosedRequest);
    }

    /**
     * Tests {@link FreeMarkerTilesRequestContext#getRequestObjects()}.
     */
    @Test
    public void testGetRequestObjects() {
        TilesRequestContext enclosedRequest = createMock(TilesRequestContext.class);

        replay(enclosedRequest);
        context = new FreeMarkerTilesRequestContext(enclosedRequest, env);
        Object[] requestObjects = context.getRequestObjects();
        assertEquals(1, requestObjects.length);
        assertEquals(env, requestObjects[0]);
        verify(enclosedRequest);
    }
}