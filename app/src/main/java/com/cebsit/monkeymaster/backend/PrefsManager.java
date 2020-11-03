package com.cebsit.monkeymaster.backend;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class PrefsManager {

    public static boolean debug, bluetooth;

    public static int num_reward_chans, default_rew_chan, max_reward_channels;
    private Context mContext;
    private SharedPreferences sharedPrefs;

    public String strobes_on, strobes_off;
    public void RewardStrobeChannels(Context context) {
        mContext = context;
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        max_reward_channels = Integer.valueOf(mContext.getString(R.string.max_reward_channels));
        num_reward_chans = sharedPrefs.getInt(r.getString(R.string.preftag_num_rew_chans), r.getInteger(R.integer.default_num_rew_chans));
        default_rew_chan = sharedPrefs.getInt(r.getString(R.string.preftag_default_rew_chan), r.getInteger(R.integer.default_rew_chan));
        if (default_rew_chan > num_reward_chans) {
            default_rew_chan = 0;
        }

        strobes_on = new String[max_reward_channels];
        strobes_off = new String[max_reward_channels];
        strobes_on[0] = sharedPrefs.getString(r.getString(R.string.preftag_strobe_one_on), r.getString(R.string.default_strobe_one_on));
        strobes_off[0] = sharedPrefs.getString(r.getString(R.string.preftag_strobe_one_off), r.getString(R.string.default_strobe_one_off));
        strobes_on[1] = sharedPrefs.getString(r.getString(R.string.preftag_strobe_two_on), r.getString(R.string.default_strobe_two_on));
        strobes_off[1] = sharedPrefs.getString(r.getString(R.string.preftag_strobe_two_off), r.getString(R.string.default_strobe_two_off));
        strobes_on[2] = sharedPrefs.getString(r.getString(R.string.preftag_strobe_three_on), r.getString(R.string.default_strobe_three_on));
        strobes_off[2] = sharedPrefs.getString(r.getString(R.string.preftag_strobe_three_off), r.getString(R.string.default_strobe_three_off));
        strobes_on[3] = sharedPrefs.getString(r.getString(R.string.preftag_strobe_four_on), r.getString(R.string.default_strobe_four_on));
        strobes_off[3] = sharedPrefs.getString(r.getString(R.string.preftag_strobe_four_off), r.getString(R.string.default_strobe_four_off));
    }
}
