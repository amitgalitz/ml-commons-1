/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.ml.common.transport.upload_chunk;

import lombok.Getter;
import org.opensearch.action.ActionResponse;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.xcontent.XContentBuilder;

import java.io.IOException;

public class MLUploadModelChunkResponse extends ActionResponse implements ToXContentObject {
    public static final String STATUS_FIELD = "status";
    @Getter
    private String status;

    public MLUploadModelChunkResponse (StreamInput in) throws IOException {
        super(in);
        this.status = in.readString();
    }

    public MLUploadModelChunkResponse (String status) {
        this.status= status;
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        out.writeString(status);
    }

    @Override
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        builder.startObject();
        builder.field(STATUS_FIELD, status);
        builder.endObject();
        return builder;
    }
}

