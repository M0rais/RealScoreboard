package josegamerpt.realscoreboard.animation;

import com.google.common.base.Strings;
import josegamerpt.realscoreboard.RealScoreboard;

import java.util.List;
import java.util.logging.Level;

public class TextLooper {

    private final List<String> list;
    private final String id;
    private String get;

    private int i = 0;

    public TextLooper(String id, List<String> s) {
        this.id = id;
        this.list = s;
    }

    public void next() {
        try {
            if (this.i >= this.list.size()) {
                this.i = 0;
            }
            this.get = list.get(i);
            this.i++;
        } catch (Exception e)
        {
            RealScoreboard.getInstance().getLogger().log(Level.WARNING, "There is something wrong with this text loop: " + this.id);
        }
    }

    public String get() {
        return Strings.isNullOrEmpty(this.get) ? this.id + " err" : this.get;
    }

}
