package org.ncb.completion;

import java.util.List;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.spi.DefaultCompletionResult;

public class CeylonCodeCompletionResult extends DefaultCompletionResult  {

    public CeylonCodeCompletionResult(List<CompletionProposal> proposals) {
        super(proposals, false);
    }

}
