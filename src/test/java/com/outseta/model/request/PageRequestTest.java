package com.outseta.model.request;

import com.outseta.constant.Sort;
import com.outseta.exception.OutsetaPageBuildException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class tests the PageRequest class.
 */
@ExtendWith(MockitoExtension.class)
public class PageRequestTest {

    /**
     * The PageRequest object to test.
     */
    private PageRequest pageRequest;

    /**
     * This method is called before each test.
     */
    @BeforeEach
    public void setUp() throws OutsetaPageBuildException {

        final int page = 1;
        final int pageSize = 10;

        pageRequest = PageRequest.builder()
                .page(page)
                .pageSize(pageSize)
                .build();
    }

    /**
     * This method tests the PageRequest's builder's constructor.
     */
    @Test
    public void testBuilderConstructor() throws OutsetaPageBuildException {

        final int page = 1;
        final int pageSize = 10;

        final PageRequest.Builder builder = new PageRequest.Builder();

        assertNotNull(builder);
        assertNull(builder.build().getPageNum());
        assertNull(builder.build().getPageSize());

        PageRequest r = builder
                .page(page)
                .pageSize(pageSize)
                .build();

        assertEquals(page, r.getPageNum());
        assertEquals(pageSize, r.getPageSize());

        final PageRequest.Builder builder1 = new PageRequest.Builder(r);

        r = builder1.build();

        assertEquals(page, r.getPageNum());
        assertEquals(pageSize, r.getPageSize());
    }

    /**
     * This method tests the PageRequest's builder method.
     */
    @Test
    public void testBuilder() throws OutsetaPageBuildException {

        final int page = 1;
        final int pageSize = 10;

        final PageRequest.Builder builder = PageRequest.builder();

        assertNotNull(builder);
        assertNull(builder.build().getPageNum());
        assertNull(builder.build().getPageSize());

        PageRequest r = builder
                .page(page)
                .pageSize(pageSize)
                .customParams(new HashMap<>())
                .orderBy("id")
                .orderByDirection(Sort.ASC)
                .build();

        assertEquals(page, r.getPageNum());
        assertEquals(pageSize, r.getPageSize());
    }

    /**
     * This method tests failure scenario of the build method.
     */
    @Test
    public void testBuildFailure() {

        final PageRequest.Builder builder = PageRequest.builder();

        assertNotNull(builder);

        assertDoesNotThrow(() -> {
            assertNull(builder.build().getPageNum());
            assertNull(builder.build().getPageSize());
        });

        assertThrows(OutsetaPageBuildException.class, () -> {
            builder.pageSize(-1).build();
        });

        assertThrows(OutsetaPageBuildException.class, () -> {
            builder.pageSize(0).build();
        });

        assertThrows(OutsetaPageBuildException.class, () -> {
            builder.page(-1).build();
        });

        assertThrows(OutsetaPageBuildException.class, () -> {
            builder.page(1)
                    .pageSize(PageRequest.MAX_PAGE_SIZE + 1).build();
        });
        assertThrows(OutsetaPageBuildException.class, () -> {
            builder.page(1)
                    .pageSize(PageRequest.MAX_PAGE_SIZE + 2).build();
        });
    }

    /**
     * This method is used to test the page getter.
     */
    @Test
    public void testGetPage() {

        final int expectedPage = 1;
        final int actualPage = pageRequest.getPageNum();

        assertEquals(expectedPage, actualPage);
    }

    /**
     * This method is used to test the page setter.
     */
    @Test
    public void testSetPage() {

        final int expectedPage = 2;
        pageRequest.setPageNum(expectedPage);
        final int actualPage = pageRequest.getPageNum();

        assertEquals(expectedPage, actualPage);
    }

    /**
     * This method is used to test the page size getter.
     */
    @Test
    public void testGetPageSize() {

        final int expectedPageSize = 10;
        final int actualPageSize = pageRequest.getPageSize();

        assertEquals(expectedPageSize, actualPageSize);
    }

    /**
     * This method is used to test the page size setter.
     */
    @Test
    public void testSetPageSize() {

        final int expectedPageSize = 20;
        pageRequest.setPageSize(expectedPageSize);
        final int actualPageSize = pageRequest.getPageSize();

        assertEquals(expectedPageSize, actualPageSize);
    }

    /**
     * This method is used to test the next page request method.
     */
    @Test
    public void testNextPageRequest() {

        final int expectedPage = 2;
        final int expectedPageSize = 10;

        assertDoesNotThrow(() -> {
            final PageRequest nextPageRequest = pageRequest.nextPageRequest();

            assertEquals(expectedPage, nextPageRequest.getPageNum());
            assertEquals(expectedPageSize, nextPageRequest.getPageSize());
        });
    }

    /**
     * This method is used to test the build params method.
     */
    @Test
    public void testBuildParams() {

        final int expectedPage = 1;
        final int expectedPageSize = 10;

        Map<String, Object> params = pageRequest.buildParams();

        assertEquals(Integer.toString(expectedPage), params.get("offset"));
        assertEquals(Integer.toString(expectedPageSize),
                params.get("limit"));
        assertNull(params.get("orderBy"));

        pageRequest.setOrderBy("");
        pageRequest.setOrderByDirection(Sort.ASC);

        params = pageRequest.buildParams();

        assertFalse(params.containsKey("orderBy"));

        pageRequest.setOrderBy("id");

        params = pageRequest.buildParams();

        assertEquals("id+ASC", params.get("orderBy"));
    }

    /**
     * This method is used to test the setCustomParams method.
     */
    @Test
    public void testSetCustomParams() {

        final int expectedPage = 1;
        final int expectedPageSize = 10;

        Map<String, Object> params = pageRequest.buildParams();

        assertEquals(Integer.toString(expectedPage), params.get("offset"));
        assertEquals(Integer.toString(expectedPageSize),
                params.get("limit"));
        assertNull(params.get("orderBy"));

        params.put("custom", "custom");

        pageRequest.setCustomParams(params);

        Map<String, Object> customParams = pageRequest.getCustomParams();
        params = pageRequest.buildParams();

        assertEquals("custom", params.get("custom"));
        assertEquals(customParams, params);
    }

    /**
     * This method is used to test the setOrderBy method.
     */
    @Test
    public void testSetOrderBy() {

        final int expectedPage = 1;
        final int expectedPageSize = 10;

        Map<String, Object> params = pageRequest.buildParams();

        assertEquals(Integer.toString(expectedPage), params.get("offset"));
        assertEquals(Integer.toString(expectedPageSize),
                params.get("limit"));
        assertNull(params.get("orderBy"));

        pageRequest.setOrderBy("id");

        params = pageRequest.buildParams();

        assertEquals("id+ASC", params.get("orderBy"));
        assertEquals("id", pageRequest.getOrderBy());
    }

    /**
     * This method is used to test the setOrderByDirection method.
     */
    @Test
    public void testSetOrderByDirection() {


        pageRequest.setOrderByDirection(Sort.DESC);

        assertEquals(Sort.DESC, pageRequest.getOrderByDirection());
    }

}
