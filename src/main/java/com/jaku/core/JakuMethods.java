package com.jaku.core;

public enum JakuMethods {
	ACCESSORY_ACCESSORY_CONNECT("accessory.accessoryConnect"),
	AD_GET_AD_METADATA("ad.getAdMetadata"),
	AD_REGISTER_AD("ad.registerAd"),
	AUTH_GET_AD_METADATA("auth.getAdMetadata"),
	AUTH_PARTNER_ADMIN_LOGIN("auth.partnerAdminLogin"),
	AUTH_PARTNER_LOGIN("auth.partnerLogin"),
	AUTH_USER_LOGIN("auth.userLogin"),
	BOOKMARK_ADD_ARTIST_BOOKMARK("bookmark.addArtistBookmark"),
	BOOKMARK_ADD_SONG_BOOKMARK("bookmark.addSongBookmark"),
	BOOKMARK_DELETE_ARTIST_BOOKMARK("bookmark.deleteArtistBookmark"),
	BOOKMARK_DELETE_SONG_BOOKMARK("bookmark.deleteSongBookmark"),
	DEVICE_ASSOCIATE_DEVICE_FOR_CASTING("device.associateDeviceForCasting"),
	DEVICE_CREATE_DEVICE("device.createDevice"),
	DEVICE_DISASSOCIATE_CASTING_DEVICE("device.disassociateCastingDevice"),
	DEVICE_DISASSOCIATE_DEVICE("device.disassociateDevice"),
	MUSIC_GET_SEARCH_RECOMMENDATIONS("music.getSearchRecommendations"),
	MUSIC_GET_TRACK("music.getTrack"),
	MUSIC_PUBLISH_SONG_SHARE("music.publishSongShare"),
	MUSIC_SEARCH("music.search"),
	MUSIC_SHARE_MUSIC("music.shareMusic"),
	STATION_ADD_FEEDBACK("station.addFeedback"),
	STATION_ADD_MUSIC("station.addMusic"),
	STATION_CREATE_STATION("station.createStation"),
	STATION_DELETE_FEEDBACK("station.deleteFeedback"),
	STATION_DELETE_MUSIC("station.deleteMusic"),
	STATION_DELETE_STATION("station.deleteStation"),
	STATION_GET_GENRE_STATIONS_CHECKSUM("station.getGenreStationsChecksum"),
	STATION_GET_GENRE_STATIONS("station.getGenreStations"),
	STATION_GET_PLAYLIST("station.getPlaylist"),
	STATION_GET_STATION("station.getStation"),
	STATION_PUBLISH_STATION_SHARE("station.publishStationShare"),
	STATION_RENAME_STATION("station.renameStation"),
	STATION_SHARE_STATION("station.shareStation"),
	STATION_TRANSFORM_SHARED_STATION("station.transformSharedStation"),
	TEST_CHECK_LICENSING("test.checkLicensing"),
	TEST_ECHO("test.echo"),
	TRACK_EXPLAIN_TRACK("track.explainTrack"),
	TRACK_TRACK_STARTED("track.trackStarted"),
	USER_ACCOUNT_MESSAGE_DISMISSED("user.accountMessageDismissed"),
	USER_ACKNOWLEDGE_SUBSCRIPTION_EXPIRATION("user.acknowledgeSubscriptionExpiration"),
	USER_ASSOCIATE_DEVICE("user.associateDevice"),
	USER_AUTHORIZE_FACEBOOK("user.authorizeFacebook"),
	USER_CAN_SUBSCRIBE("user.canSubscribe"),
	USER_CHANGE_SETTINGS("user.changeSettings"),
	USER_CREATE_USER("user.createUser"),
	USER_DISCONNECT_FACEBOOK("user.disconnectFacebook"),
	USER_EMAIL_PASSWORD("user.emailPassword"),
	USER_FACEBOOK_AUTH_FAILED("user.facebookAuthFailed"),
	USER_GET_BOOKMARK("user.getBookmarks"),
	USER_GET_FACEBOOK_INFO("user.getFacebookInfo"),
	USER_GET_SETTINGS("user.getSettings"),
	USER_GET_STATION_LIST_CHECKSUM("user.getStationListChecksum"),
	USER_GET_STATION_LIST("user.getStationList"),
	USER_GET_USAGE_INFO("user.getUsageInfo"),
	USER_PURCHASE_AMAZON_PAY_TO_PLAY("user.purchaseAmazonPayToPlay"),
	USER_PURCHASE_AMAZON_SUBSCRIPTION("user.purchaseAmazonSubscription"),
	USER_PURCHASE_GOOGLE_PAY_TO_PLAY("user.purchaseGooglePayToPlay"),
	USER_PURCHASE_GOOGLE_SUBSCRIPTIO("user.purchaseGoogleSubscription"),
	USER_PURCHASE_ITUNES_SUBSCRIPTION("user.purchaseItunesSubscription"),
	USER_SET_AWARE_OF_PROFILE("user.setAwareOfProfile"),
	USER_SET_EXPLICIT_CONTENT_FILTER("user.setExplicitContentFilter"),
	USER_SET_QUICK_MIX("user.setQuickMix"),
	USER_SLEEP_SONG("user.sleepSong"),
	USER_START_COMPLIMENTARY_TRIAL("user.startComplimentaryTrial"),
	USER_VALIDATE_USERNAME("user.validateUsername");

	private final String method;

	JakuMethods(String method) {
		this.method = method;
	}

	public String getValue() {
		return method;
	}
}
